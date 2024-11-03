package novalogics.android.styles.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import novalogics.android.styles.R
import novalogics.android.styles.ui.theme.StylesByNovaTheme


@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.2f))
            .wrapContentSize(Alignment.Center)
    ) {
        ElevatedCard(
            modifier = Modifier,
            elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation_medium_4dp)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium_8dp))
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xlarge_32dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                CircularProgressIndicator()
                Spacer(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small_4dp))
                )
                Text(
                    text = stringResource(id = R.string.please_wait),
                    fontSize = textSizeResource(id = R.dimen.text_size_large_18sp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }
    }
}

@Preview
@Composable
fun SimpleLoadingPreview() {
    StylesByNovaTheme {
        Surface {
            LoadingScreen()
        }
    }
}
