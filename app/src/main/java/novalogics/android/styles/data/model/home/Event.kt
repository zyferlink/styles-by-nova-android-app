package novalogics.android.styles.data.model.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    @StringRes
    val nameResId: Int,
    @StringRes
    val categoryResId: Int,
    @DrawableRes
    val imageResId: Int
)
