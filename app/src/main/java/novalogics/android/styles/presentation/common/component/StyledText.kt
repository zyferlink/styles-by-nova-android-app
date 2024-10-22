package novalogics.android.styles.presentation.common.component

import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import novalogics.android.styles.R
import java.util.Locale

@Composable
fun StyledText(
    modifier: Modifier = Modifier,
    @StringRes
    stringResId: Int,
    @DimenRes
    letterSpacing: Int = R.dimen.Latter_space_small_1dp,
    @DimenRes
    fontSize: Int = R.dimen.text_size_large_18sp,
    style: TextStyle = typography.displaySmall,
    color: Color = colorScheme.onPrimaryContainer,
    fontWeight: FontWeight = FontWeight.Bold,
    isUppercase: Boolean = false,
    makeSyllable: Boolean = false,
) {
    val textValue = when {
        isUppercase -> stringResource(id = stringResId).uppercase(Locale.ROOT)
        makeSyllable -> "- ${stringResource(id = stringResId).uppercase(Locale.ROOT)} -"
        else -> stringResource(id = stringResId)
    }

    Text(
        text = textValue,
        style = style,
        letterSpacing = textSizeResource(id = letterSpacing),
        fontSize = textSizeResource(id = fontSize),
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}
