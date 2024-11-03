package novalogics.android.styles.presentation.ui.home.component

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
import novalogics.android.styles.R

@Composable
fun ViewPagerUnit(
    bannerUrls: List<String>,
    pageIndex: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.size_3xlarge_248dp))
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.banner_women),
            contentDescription = "Loading placeholder",
            modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.img_home_banner_1),
            contentDescription = "Loading placeholder",
            modifier = Modifier.fillMaxSize().padding(2.dp),
            contentScale = ContentScale.Inside
        )


//            SubcomposeAsyncImage(
//                model = bannerUrls[pageIndex],
//                contentDescription = "Banner Image",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//                val state = painter.state
//
//                when (state) {
//                    is AsyncImagePainter.State.Loading -> {
//
//                        Box(modifier = Modifier.fillMaxSize()) {
//                            Image(
//                                painter = painterResource(id = R.drawable.img_home_banner_2),
//                                contentDescription = "Loading placeholder",
//                                modifier = Modifier.fillMaxSize().padding(start = 8.dp, end = 8.dp),
//                                contentScale = ContentScale.FillBounds
//                            )
//                            Image(
//                                painter = painterResource(id = R.drawable.img_home_banner_1),
//                                contentDescription = "Loading placeholder",
//                                modifier = Modifier.fillMaxSize().padding(16.dp),
//                                contentScale = ContentScale.Inside
//                            )
//
//                            CircularProgressIndicator(
//                                modifier = Modifier
//                                    .align(Alignment.Center)
//                                    .size(48.dp)
//                            )
//                        }
//                    }
//
//                    is AsyncImagePainter.State.Error -> {
//                        // Show the error image if the loading fails
//                        Image(
//                            painter = painterResource(id = R.drawable.placeholder_banner_error),
//                            contentDescription = "Error placeholder",
//                            modifier = Modifier.fillMaxSize(),
//                            contentScale = ContentScale.Crop
//                        )
//                    }
//
//                    else -> {
//                        SubcomposeAsyncImageContent()
//                    }
//                }
//
//            }

    }
}

@Preview
@Composable
private fun ViewPagerItemPreview() {
    ViewPagerUnit(
        bannerUrls = listOf(),
        pageIndex = 0
    )
}
