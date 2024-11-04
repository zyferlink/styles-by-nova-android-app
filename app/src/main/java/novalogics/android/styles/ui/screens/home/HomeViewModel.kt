package novalogics.android.styles.ui.screens.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import novalogics.android.styles.data.datastore.DataStoreKeys
import novalogics.android.styles.data.datastore.DataStoreRepository
import novalogics.android.styles.data.repository.HomeRepositoryOffline
import novalogics.android.styles.data.type.FashionCategory
import novalogics.android.styles.util.Constants.DELAY_2_SECONDS
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val repositoryOffline: HomeRepositoryOffline,
    private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    private fun reduce(currentState: HomeUiState, intent: HomeIntent): HomeUiState {
        return when (intent) {
            is HomeIntent.LoadData -> currentState.copy(isLoading = true)
            is HomeIntent.UpdateSearchField -> currentState.copy(searchFieldValue = intent.newValue)
            is HomeIntent.CategoryChangeActions -> currentState.copy(selectedFashionCategory = intent.category)
            is HomeIntent.ClearError -> currentState.copy(error = null)
        }
    }

    fun handleIntent(intent: HomeIntent) {
        _uiState.value = reduce(_uiState.value, intent)

        // side-effect handling
        when (intent) {
            is HomeIntent.LoadData -> loadDataOffline()
            is HomeIntent.CategoryChangeActions -> handleCategoryChangeActions(intent.category)
            else -> {}
        }
    }

    init {
        loadDataOffline()
    }

    private fun loadDataOffline() {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                currentUiState.copy(
                    isLoading = true,
                    bannerItemList = repositoryOffline.getBannerUrls(),
                )
            }

            handleIntent(HomeIntent.CategoryChangeActions(getFashionCategory()))

            delay(DELAY_2_SECONDS)

            _uiState.update { currentUiState ->
                currentUiState.copy(isLoading = false)
            }
        }
    }


    private fun handleCategoryChangeActions(category: FashionCategory){
        when (category) {
            FashionCategory.DEFAULT,
            FashionCategory.WOMEN -> {
                _uiState.update { currentUiState ->
                    currentUiState.copy(
                        eventCategoryList = repositoryOffline.getDemoEventsWomen()
                    )
                }

                saveFashionCategory(FashionCategory.WOMEN.name)
            }
            FashionCategory.MEN -> {
                _uiState.update { currentUiState ->
                    currentUiState.copy(
                        eventCategoryList = repositoryOffline.getDemoEventsMen()
                    )
                }
                saveFashionCategory(FashionCategory.MEN.name)
            }
         //   FashionCategory.KIDS -> {}
            else -> {}
        }
    }

    private fun saveFashionCategory(value: String) {
        viewModelScope.launch {
            dataStoreRepository.putString(DataStoreKeys.FashionCategory.key, value)
        }
    }

    private fun getFashionCategory(): FashionCategory {
        return try {
            FashionCategory.valueOf(getFashionCategoryAsString())
        } catch (e: IllegalArgumentException) {
            FashionCategory.DEFAULT
        }
    }

    private fun getFashionCategoryAsString(): String = runBlocking {
        //runBlocking : Runs a new coroutine and blocks the current thread until its completion.
        dataStoreRepository.getString(DataStoreKeys.FashionCategory.key) ?: FashionCategory.DEFAULT.name
    }


    fun handleError() {
        _uiState.value = HomeUiState(error = "Something went wrong!")
    }
}
