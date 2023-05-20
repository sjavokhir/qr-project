package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.Dp

expect fun rememberQrBitmapPainter(
    content: String,
    size: Dp,
    padding: Dp
): BitmapPainter