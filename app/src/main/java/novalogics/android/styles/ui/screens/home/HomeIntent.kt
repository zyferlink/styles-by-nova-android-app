package novalogics.android.styles.ui.screens.home

import novalogics.android.styles.data.type.FashionCategory

sealed class HomeIntent {
    data object LoadData : HomeIntent()
    data class ChangeSearchText(val newValue: String) : HomeIntent()
    data class ChangeFashionCategory(val category: FashionCategory) : HomeIntent()
    data object ClearError : HomeIntent()
}
