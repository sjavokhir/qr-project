package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import platform.UIKit.UIImage

class IosImage(
    val uiImage: UIImage
)

actual typealias PlatformImage = IosImage