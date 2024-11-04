package novalogics.android.styles.data.model.home

import androidx.annotation.DrawableRes
import novalogics.android.styles.data.type.FashionCategory

data class EventEntity(
    val id: Int,
    val name: String,
    val eventCategory: String,
    val fashionCategory: FashionCategory,
    val description: String?,
    val imageLink: String?,
    @DrawableRes
    val imageResId: Int,
)
