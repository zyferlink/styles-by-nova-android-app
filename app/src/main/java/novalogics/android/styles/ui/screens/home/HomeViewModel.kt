package novalogics.android.styles.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import novalogics.android.styles.data.datastore.DataStoreKeys
import novalogics.android.styles.data.datastore.DataStoreRepository
import novalogics.android.styles.data.repository.local.LocalDataRepository
import novalogics.android.styles.data.type.FashionCategory
import novalogics.android.styles.util.Constants.DELAY_1_SECOND
import novalogics.android.styles.util.Constants.DELAY_2_SECONDS
import novalogics.android.styles.util.Constants.DELAY_4_SECONDS
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val localDataRepository: LocalDataRepository,
    private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    private fun reduce(
        currentState: HomeUiState,
        intent: HomeIntent
    ): HomeUiState {

        return when (intent) {
            is HomeIntent.LoadData -> currentState.copy(isLoading = true)
            is HomeIntent.ChangeSearchText -> currentState.copy(searchFieldValue = intent.newValue)
            is HomeIntent.ChangeFashionCategory -> currentState.copy(fashionCategory = intent.category)
            is HomeIntent.ClearError -> currentState.copy(error = null)
        }
    }

    fun handleIntent(intent: HomeIntent) {
        _uiState.value = reduce(_uiState.value, intent)

        when (intent) { // side-effect handling
            is HomeIntent.LoadData -> loadDataOffline()
            is HomeIntent.ChangeFashionCategory -> handleCategoryChangeActions(intent.category)
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
                    bannerItems = localDataRepository.getBannerUrls(),
                )
            }

            handleIntent(
                HomeIntent.ChangeFashionCategory(getFashionCategory())
            )

            delay(DELAY_4_SECONDS)

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
                        eventCategories = localDataRepository.getWomenEvents()
                    )
                }

                saveFashionCategory(FashionCategory.WOMEN.name)
            }
            FashionCategory.MEN -> {
                _uiState.update { currentUiState ->
                    currentUiState.copy(
                        eventCategories = localDataRepository.getMenEvents()
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
            dataStoreRepository.putString(DataStoreKeys.SelectedFashionCategory.key, value)
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
        dataStoreRepository.getString(
            key = DataStoreKeys.SelectedFashionCategory.key,
            defaultValue = FashionCategory.DEFAULT.name
        )
    }

    fun handleError() {
        _uiState.value = HomeUiState(error = "Something went wrong!")
    }
}
