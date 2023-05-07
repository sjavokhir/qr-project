package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import platform.UIKit.UIImage

class IosImage(
    val rawValue: UIImage
)

actual typealias PlatformImage = IosImage