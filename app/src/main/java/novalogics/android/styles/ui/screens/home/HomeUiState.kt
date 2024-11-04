package novalogics.android.styles.ui.screens.home

import novalogics.android.styles.data.model.home.EventEntity
import novalogics.android.styles.data.type.FashionCategory

data class HomeUiState(
    val isLoading: Boolean = false,
    val bannerItems: List<String> = emptyList(),
    val eventCategories: List<EventEntity> = emptyList(),
    val fashionCategory: FashionCategory = FashionCategory.DEFAULT,
    val searchFieldValue: String = "",
    val error: String? = null
)
