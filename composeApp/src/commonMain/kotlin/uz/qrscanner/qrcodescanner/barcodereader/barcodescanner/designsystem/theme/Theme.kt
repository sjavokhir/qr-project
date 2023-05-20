package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun QrTheme(content: @Composable () -> Unit) {
    val colors = lightColors(
        primary = Primary,
        primaryVariant = PrimaryVariant,
        secondary = Secondary,
        secondaryVariant = SecondaryVariant,
        background = Background,
        surface = Surface,
        error = Error,
        onPrimary = OnPrimary,
        onSecondary = OnSecondary,
        onBackground = OnBackground,
        onSurface = OnBackground,
        onError = OnError
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
