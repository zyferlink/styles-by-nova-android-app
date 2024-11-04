package novalogics.android.styles.ui.screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import novalogics.android.styles.R
import novalogics.android.styles.ui.common.component.StyledText
import novalogics.android.styles.ui.navigation.AppScreens
import novalogics.android.styles.ui.screens.home.HomeScreen
import novalogics.android.styles.ui.screens.mainscreen.component.BottomNavigationBar


@Composable
fun StylesMainScreen(
    navController: NavHostController = rememberNavController()
){
    val context = LocalContext.current
    val tabItems = context.resources.getStringArray(R.array.tab_items).toList()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = tabItems
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreens.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(route = AppScreens.Home.name) {
                HomeScreen()
            }

            composable(route = AppScreens.Category.name) {
                CategoryScreen()
            }

            composable(route = AppScreens.Trending.name) {
                TrendingScreen()
            }

            composable(route = AppScreens.You.name) {
                YouScreen()
            }

        }
    }
}

@Composable
fun TrendingScreen() {
    BlankScreen(screenName = "Trending Screen")
}

@Composable
fun CategoryScreen() {
    BlankScreen(screenName = "Category Screen")
}

@Composable
fun YouScreen() {
    BlankScreen(screenName = "Profile Screen")
}

@Preview
@Composable
fun BlankScreen(
    screenName: String = "Home"
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.padding_large_24dp))
        ) {

            Image(
                painter = painterResource(id = R.drawable.banner_women),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.Inside
            )

            StyledText(
                stringValue = "[$screenName]\nWe Are Under Maintenance",
                letterSpacing = R.dimen.letter_space_small_1dp,
                style = typography.displayMedium,
                fontSize = R.dimen.text_size_large_20sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.padding_large_24dp))
            )
        }
    }
}


