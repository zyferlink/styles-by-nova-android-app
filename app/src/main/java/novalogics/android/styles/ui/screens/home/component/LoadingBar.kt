package novalogics.android.styles.ui.screens.home.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import novalogics.android.styles.R
import novalogics.android.styles.ui.common.component.textSizeResource
import novalogics.android.styles.ui.theme.StylesByNovaTheme
import novalogics.android.styles.util.Constants

@Composable
fun LoadingBar(
    isLoading: Boolean,
    message: String = "Loading...",
    modifier: Modifier = Modifier
) {
    // Animated visibility to slide in and out
    AnimatedVisibility(
        visible = isLoading,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium_16dp))
                .background(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large_24dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.size_medium_40dp))
                )
                Spacer(
                    modifier = Modifier.width(dimensionResource(id = R.dimen.padding_large_24dp))
                )
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.displayMedium,
                    fontSize = textSizeResource(id = R.dimen.text_size_large_20sp),
                    modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_xlarge_32dp))
                )
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
private fun ViewPagerItemPreview() {
    StylesByNovaTheme {
        Surface {
            LoadingBar(
                isLoading = true
            )
        }
    }
}
