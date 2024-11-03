package novalogics.android.styles.app

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import novalogics.android.styles.ui.theme.StylesByNovaTheme
import novalogics.android.styles.ui.screens.mainscreen.StylesMainScreen
import novalogics.android.styles.util.Constants

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO : Only for testing
        installSplashScreen().setKeepOnScreenCondition {
            runBlocking { delay(1000) }
            false
        }
        enableEdgeToEdge()
        setContent {
            StylesByNovaTheme {
                StylesMainScreen()
            }
        }
    }
}

@Preview(
    name = Constants.MODE_LIGHT,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = Constants.MODE_NIGHT,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun AppPreview() {
    StylesByNovaTheme {
        StylesMainScreen()
    }
}
