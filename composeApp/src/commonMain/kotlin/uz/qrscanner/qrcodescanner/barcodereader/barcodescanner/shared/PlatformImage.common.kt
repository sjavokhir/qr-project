package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import androidx.compose.ui.graphics.ImageBitmap

expect class PlatformImage

expect fun PlatformImage.getImageBitmap(): ImageBitmap?

expect fun ByteArray.toImageBitmap(): ImageBitmap
