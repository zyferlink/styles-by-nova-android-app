package novalogics.android.styles.presentation.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import novalogics.android.styles.R
import novalogics.android.styles.data.model.home.EventEntity
import novalogics.android.styles.data.repository.HomeRepositoryOffline
import novalogics.android.styles.presentation.common.component.LoadingScreen
import novalogics.android.styles.presentation.common.component.StyledText
import novalogics.android.styles.presentation.theme.StylesByNovaTheme
import novalogics.android.styles.presentation.ui.home.component.CustomDropdown
import novalogics.android.styles.presentation.ui.home.component.SearchBarStatic
import novalogics.android.styles.presentation.ui.home.component.TopAppBar
import novalogics.android.styles.presentation.ui.home.component.ViewPagerDotsIndicator
import novalogics.android.styles.presentation.ui.home.component.ViewPagerUnit
import novalogics.android.styles.util.Constants


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val uiState by viewModel.uiState.collectAsState()

    ScreenUiContent(
        uiState = uiState
    )

}

@Composable
fun ScreenUiContent(
    uiState : HomeUiState,
){
    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_vector_2),
            contentDescription = null,
            modifier = Modifier
                .alpha(0.1f)
                .fillMaxWidth()
                .height(240.dp)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            //Pinned Headers
            TopAppBar(
                modifier = Modifier
            )
            HeaderSearchAndDropdown()

            LazyColumn(
                state = scrollState,
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    HorizontalPager(
                        bannerUrls = uiState.bannerData,
                    )
                }
                item {
                    StyledText(
                        stringResId = R.string.stay_stylish_for_any_event,
                        letterSpacing = R.dimen.Latter_space_small_2dp,
                        style = typography.displayMedium,
                        modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.padding_medium_16dp))
                    )
                }
                item {
                    EventGridView(
                        events = uiState.eventData
                    )
                }
            }
        }

        if (uiState.isLoading) {
            LoadingScreen()
        }
    }
}

@Composable
fun HeaderSearchAndDropdown() {

    val dropdownItems = LocalContext.current.resources.getStringArray(R.array.dropdown_items).toList()

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = dimensionResource(id = R.dimen.padding_medium_16dp),
            end = dimensionResource(id = R.dimen.padding_medium_16dp),
            top = dimensionResource(id = R.dimen.padding_regular_8dp),
            bottom = dimensionResource(id = R.dimen.padding_regular_8dp),
        )
    ) {
        SearchBarStatic(
            onClick = { },
            modifier = Modifier
                .weight(0.7f)
        )

        CustomDropdown(
            items = dropdownItems,
            modifier = Modifier
                .weight(0.3f)
                .height(40.dp),
        )
    }
}

@Composable
fun HorizontalPager(
    bannerUrls: List<String>,
) {
    val pageCount = bannerUrls.size
    val pagerState = rememberPagerState(pageCount = { pageCount })

    Box(
        modifier = Modifier
    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            ViewPagerUnit(
                bannerUrls = bannerUrls,
                pageIndex = page
            )
        }
        ViewPagerDotsIndicator(
            pageCount = pageCount,
            currentPageIteration = pagerState.currentPage,
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.size_large_48dp))
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun EventGridView(
    events: List<EventEntity>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.size_4xlarge_600dp)),
        content = {
            items(events) { event ->
                EventItem(
                    event = event
                )
            }
        }
    )
}

@Composable
fun EventItem(
    event: EventEntity
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Image(
                painter = painterResource(id = event.imageResId),
                contentDescription = stringResource(id = R.string.event_item_content_description),
                modifier = Modifier
                    .height(180.dp)
                    .background(colorScheme.onBackground),
                contentScale = ContentScale.Crop
            )
        }

        StyledText(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_regular_8dp)),
            stringResId = event.nameResId,
            fontSize = R.dimen.text_size_small_12sp,
            style = typography.displayMedium,
            isUppercase = true
        )

        StyledText(
            modifier = Modifier.offset(y = 2.dp),
            stringResId = event.categoryResId,
            fontSize = R.dimen.text_size_xsmall_10sp,
            color = colorScheme.onSecondaryContainer,
            style = typography.labelSmall,
            makeSyllable = true
        )
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
fun HomeScreenPreview(){
    val uiState = HomeUiState(
        bannerData = HomeRepositoryOffline().getBannerUrls(),
        eventData = HomeRepositoryOffline().getDemoEventsWomen(),
    )

    StylesByNovaTheme {
        ScreenUiContent(
            uiState = uiState
        )
    }
}
