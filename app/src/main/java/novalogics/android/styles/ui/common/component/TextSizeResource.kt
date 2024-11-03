package novalogics.android.styles.ui.common.component

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@Composable
@ReadOnlyComposable
fun textSizeResource(@DimenRes id: Int): TextUnit {
    val context = LocalContext.current
    val density = LocalDensity.current
    val pxValue = context.resources.getDimension(id)
    return TextUnit(pxValue / density.density, TextUnitType.Sp)
}
