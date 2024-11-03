package novalogics.android.styles.ui.screens.mainscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import novalogics.android.styles.R
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
    Text(text = "Trending Screen", modifier = Modifier.fillMaxSize())
}

@Composable
fun CategoryScreen() {
    Text(text = "Category Screen", modifier = Modifier.fillMaxSize())
}

@Composable
fun YouScreen() {
    Text(text = "You Screen", modifier = Modifier.fillMaxSize())
}



