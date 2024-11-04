package novalogics.android.styles.ui.screens.home.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import kotlinx.coroutines.delay
import novalogics.android.styles.R
import novalogics.android.styles.data.type.FashionCategory

@Composable
fun ViewPagerUnit(
    bannerUrls: List<String>,
    pageIndex: Int,
    category: FashionCategory
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.size_3xlarge_242dp))
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        if(pageIndex == 0){

            val backgroundResIds: List<Int> = listOf(
                R.drawable.img_banner_bg_1,
                R.drawable.img_banner_bg_2,
                R.drawable.img_banner_bg_3
            )

            val foreground =
                if (category == FashionCategory.MEN) R.drawable.img_banner_men_1
                else R.drawable.img_banner_women_1


            var index by remember { mutableIntStateOf(0) }

            // Update the index every 10 seconds
            LaunchedEffect(key1 = index) {
                delay(4000L) // 10 seconds delay
                index = (index + 1) % backgroundResIds.size // Cycle through images
            }

            Crossfade(targetState = index, label = "") { currentIndex ->
                Image(
                    painter = painterResource(id = backgroundResIds[currentIndex]),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
            Image(
                painter = painterResource(id = foreground),
                contentDescription = "Loading placeholder",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp),
                contentScale = ContentScale.Inside
            )

        } else {
            ElevatedCard(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium_16dp)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(id = R.dimen.elevation_medium_4dp)
                ),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium_8dp))
            ) {

                SubcomposeAsyncImage(
                    model = bannerUrls[pageIndex],
                    contentDescription = "Banner Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val state = painter.state

                    when (state) {
                        is AsyncImagePainter.State.Loading -> {

                            Box(modifier = Modifier.fillMaxSize()) {
                                LoadImage(
                                    drawableResId = R.drawable.banner_women,
                                    contentDescription = "Loading placeholder"
                                )
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(48.dp)
                                )
                            }
                        }

                        is AsyncImagePainter.State.Error -> { // Show the error image if the loading fails
                            LoadImage(
                                drawableResId = R.drawable.placeholder_banner_error,
                                contentDescription = "Error placeholder"
                            )
                        }

                        else -> {
                            SubcomposeAsyncImageContent()
                        }
                    }

                }
            }
        }


    }
}

@Composable
private fun LoadImage(
    @DrawableRes
    drawableResId: Int,
    contentDescription: String
){
    Image(
        painter = painterResource(id = drawableResId),
        contentDescription = "Error placeholder",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Preview
@Composable
private fun ViewPagerItemPreview() {
    ViewPagerUnit(
        bannerUrls = listOf(),
        pageIndex = 0,
        category = FashionCategory.WOMEN
    )
}
