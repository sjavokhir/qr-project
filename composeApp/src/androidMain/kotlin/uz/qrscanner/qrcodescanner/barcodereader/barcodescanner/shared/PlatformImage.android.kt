package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import androidx.compose.ui.graphics.ImageBitmap

class AndroidImage(
    val imageBitmap: ImageBitmap
)

actual typealias PlatformImage = AndroidImage