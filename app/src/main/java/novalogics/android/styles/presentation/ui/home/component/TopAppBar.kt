package novalogics.android.styles.presentation.ui.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import novalogics.android.styles.R
import novalogics.android.styles.presentation.common.component.textSizeResource
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = stringResource(id = R.string.styles).uppercase(Locale.ROOT),
                    style = MaterialTheme.typography.displayLarge.copy(
                        letterSpacing = 2.sp
                    ),
                    fontSize = 28.sp,
                    lineHeight = 0.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .offset(y = 10.dp)
                        .padding(bottom = 0.dp)
                )
                Text(
                    text = stringResource(id = R.string.by_nova),
                    style = MaterialTheme.typography.displayMedium.copy(
                        lineHeight = 0.sp
                    ),
                    lineHeight = 0.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = textSizeResource(id = R.dimen.text_size_small_12sp),
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.padding_xsmall_2dp))
                )
            }

        },
        actions = {
            IconButton(onClick = { /* Handle favorite click */ }) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite"
                )
            }
            IconButton(onClick = { /* Handle notifications click */ }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.background)
    )
}
