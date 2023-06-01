package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.PlatformImage

expect fun rememberQrImage(
    content: String,
    size: Int,
    padding: Int
): PlatformImage?