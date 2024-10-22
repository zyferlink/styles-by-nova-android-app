package novalogics.android.styles.presentation.navigation

import androidx.annotation.StringRes
import novalogics.android.styles.R

enum class AppScreens (@StringRes val title: Int){
    Home(title = R.string.home),
    Category(title = R.string.category),
    Trending(title = R.string.trending),
    You(title = R.string.you),
}
