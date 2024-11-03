package novalogics.android.styles.presentation.ui.home

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
            delay(4000)
            _uiState.update { it.copy(isLoading = false) }
        }
    }


    fun handleError() {
        _uiState.value = HomeUiState(error = "Something went wrong!")
    }
}
