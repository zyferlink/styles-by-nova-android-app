package novalogics.android.styles.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import novalogics.android.styles.R

@Composable
fun ViewPagerDotsIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPageIteration: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {

        repeat(
            pageCount
        ) { iteration ->

            val color =
                if (currentPageIteration == iteration) MaterialTheme.colorScheme.primary
                else Color.White
            Box(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_regular_8dp))
                    .clip(CircleShape)
                    .background(color)
                    .size(dimensionResource(id = R.dimen.size_xsmall_8dp))
            )
        }
    }
}

@Preview
@Composable
private fun ViewPagerDotsIndicatorPreview() {
    ViewPagerDotsIndicator(
        pageCount = 5,
        currentPageIteration = 2
    )
}
