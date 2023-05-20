package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
actual fun rememberQrBitmapPainter(
    content: String,
    size: Dp,
    padding: Dp
): BitmapPainter {
    val density = LocalDensity.current
    val sizePx = with(density) { size.roundToPx() }

    val currentBitmap = ImageBitmap(
        sizePx,
        sizePx,
        ImageBitmapConfig.Argb8888,
    )

    return BitmapPainter(currentBitmap)
}