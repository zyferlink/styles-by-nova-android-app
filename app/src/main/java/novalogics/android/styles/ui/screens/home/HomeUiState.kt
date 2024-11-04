package novalogics.android.styles.ui.screens.home

import novalogics.android.styles.data.model.home.Event
import novalogics.android.styles.data.model.home.EventEntity
import novalogics.android.styles.data.type.FashionCategory

data class HomeUiState(
    val isLoading: Boolean = false,
    val bannerItemList: List<String> = emptyList(),
    val eventCategoryList: List<EventEntity> = emptyList(),
    val selectedFashionCategory: FashionCategory = FashionCategory.DEFAULT,
    val searchFieldValue: String = "",
    val error: String? = null
)
