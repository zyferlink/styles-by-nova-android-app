package novalogics.android.styles.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(50.dp),

    medium = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 24.dp,
        bottomStart = 24.dp,
        bottomEnd = 0.dp
    )
)
