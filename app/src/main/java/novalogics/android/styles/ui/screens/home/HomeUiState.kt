package novalogics.android.styles.ui.screens.home

import novalogics.android.styles.data.model.home.EventEntity

data class HomeUiState(
    val isLoading: Boolean = false,
    val bannerData: List<String> = emptyList(),
    val eventData: List<EventEntity> = emptyList(),
    val data: String? = null,
    val error: String? = null
)
