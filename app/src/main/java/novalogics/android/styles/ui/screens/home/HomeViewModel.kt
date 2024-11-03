package novalogics.android.styles.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import novalogics.android.styles.data.repository.HomeRepositoryOffline
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryOffline: HomeRepositoryOffline
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    private fun reduce(currentState: HomeUiState, intent: HomeIntent): HomeUiState {
        return when (intent) {
            is HomeIntent.LoadData -> currentState.copy(isLoading = true)
            is HomeIntent.UpdateSearchField -> currentState.copy(searchFieldValue = intent.newValue)
            is HomeIntent.CategoryChangeActions -> currentState.copy(selectedMainCategory = intent.category)
            is HomeIntent.ClearError -> currentState.copy(error = null)
        }
    }

    fun handleIntent(intent: HomeIntent) {
        _uiState.value = reduce(_uiState.value, intent)

        // side-effect handling
        when (intent) {
            is HomeIntent.LoadData -> loadData()
            is HomeIntent.CategoryChangeActions -> handleCategoryChangeActions()
            else -> {}
        }
    }

    private fun loadData(){

    }

    private fun handleCategoryChangeActions(){

    }

    init {
        loadDataOffline()
    }

    private fun loadDataOffline() {
        _uiState.update { ui ->
            ui.copy(
                isLoading = true,
                bannerData = repositoryOffline.getBannerUrls(),
                eventData = repositoryOffline.getDemoEventsWomen()
            )
        }

        viewModelScope.launch {
            delay(2000)
            _uiState.update { it.copy(isLoading = false) }
        }
    }


    fun handleError() {
        _uiState.value = HomeUiState(error = "Something went wrong!")
    }
}
