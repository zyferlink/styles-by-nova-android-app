package novalogics.android.styles.ui.screens.home

import novalogics.android.styles.data.type.MainCategory

sealed class HomeIntent {
    data object LoadData : HomeIntent()
    data class UpdateSearchField(val newValue: String) : HomeIntent()
    data class CategoryChangeActions(val category: MainCategory) : HomeIntent()
    data object ClearError : HomeIntent()
}
