package novalogics.android.styles.ui.screens.home

import novalogics.android.styles.data.model.home.EventEntity
import novalogics.android.styles.data.type.MainCategory

data class HomeUiState(
    val isLoading: Boolean = false,
    val bannerItemList: List<String> = emptyList(),
    val eventCategoryList: List<EventEntity> = emptyList(),
    val categoryList: List<String> = emptyList(),
    val selectedMainCategory: MainCategory = MainCategory.NONE,
    val searchFieldValue: String = "",
    val error: String? = null
)
