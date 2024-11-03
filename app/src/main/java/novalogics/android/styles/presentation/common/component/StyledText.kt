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
import androidx.compose.ui.text.style.TextAlign
import novalogics.android.styles.R
import java.util.Locale

@Composable
fun StyledText(
    modifier: Modifier = Modifier,
    @StringRes
    stringResId: Int,
    @DimenRes
    letterSpacing: Int = R.dimen.letter_space_small_1dp,
    @DimenRes
    fontSize: Int = R.dimen.text_size_large_18sp,
    style: TextStyle = typography.displaySmall,
    color: Color = colorScheme.onPrimaryContainer,
    fontWeight: FontWeight = FontWeight.Bold,
    textAlign: TextAlign = TextAlign.Start,
    isUppercase: Boolean = false,
    makeSyllable: Boolean = false,
) {
    val textValue : String = when {
        isUppercase -> stringResource(id = stringResId).uppercase(Locale.ROOT)
        makeSyllable -> "- ${stringResource(id = stringResId).uppercase(Locale.ROOT)} -"
        else -> stringResource(id = stringResId)
    }

    StyledText(
        stringValue = textValue,
        style = style,
        letterSpacing =  letterSpacing,
        fontSize =  fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign,
        color = color,
        modifier = modifier
    )
}




@Composable
fun StyledText(
    modifier: Modifier = Modifier,
    stringValue: String,
    @DimenRes
    letterSpacing: Int = R.dimen.letter_space_small_1dp,
    @DimenRes
    fontSize: Int = R.dimen.text_size_large_18sp,
    style: TextStyle = typography.displaySmall,
    color: Color = colorScheme.onPrimaryContainer,
    fontWeight: FontWeight = FontWeight.Bold,
    textAlign: TextAlign = TextAlign.Start,
    isUppercase: Boolean = false,
    makeSyllable: Boolean = false,
) {
    val textValue = when {
        isUppercase -> stringValue.uppercase(Locale.ROOT)
        makeSyllable -> "- ${stringValue.uppercase(Locale.ROOT)} -"
        else -> stringValue
    }

    Text(
        text = textValue,
        style = style,
        letterSpacing = textSizeResource(id = letterSpacing),
        fontSize = textSizeResource(id = fontSize),
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}
