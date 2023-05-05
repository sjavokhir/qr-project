package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlinx.cinterop.useContents
import kotlinx.coroutines.Dispatchers
import platform.CoreFoundation.CFUUIDCreate
import platform.CoreFoundation.CFUUIDCreateString
import platform.Foundation.CFBridgingRelease
import platform.Foundation.NSURL
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIImage
import platform.UIKit.UIWindow

class IosStorableImage(
    val rawValue: UIImage
)

actual typealias PlatformStorableImage = IosStorableImage

private val iosNotchInset = object : WindowInsets {
    override fun getTop(density: Density): Int {
        val safeAreaInsets = UIApplication.sharedApplication.keyWindow?.safeAreaInsets
        return if (safeAreaInsets != null) {
            val topInset = safeAreaInsets.useContents { this.top }
            (topInset * density.density).toInt()
        } else {
            0
        }
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int = 0
    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int = 0
    override fun getBottom(density: Density): Int {
        val safeAreaInsets = UIApplication.sharedApplication.keyWindow?.safeAreaInsets
        return if (safeAreaInsets != null) {
            val bottomInset = safeAreaInsets.useContents { this.bottom }
            (bottomInset * density.density).toInt()
        } else {
            0
        }
    }
}

actual fun Modifier.notchPadding(): Modifier =
    this.windowInsetsPadding(iosNotchInset)

actual fun openUrl(url: String) {
    val nsUrl = NSURL.URLWithString(url) ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}

actual fun shareText(text: String) {
    val window = UIApplication.sharedApplication.windows.last() as? UIWindow
    val currentViewController = window?.rootViewController
    val activityViewController = UIActivityViewController(
        activityItems = listOf(text),
        applicationActivities = null
    )
    currentViewController?.presentViewController(
        viewControllerToPresent = activityViewController,
        animated = true,
        completion = null,
    )
}

actual fun randomUUID(): String =
    CFBridgingRelease(CFUUIDCreateString(null, CFUUIDCreate(null))) as String

actual val mainDispatcher = Dispatchers.Main
actual val ioDispatcher = Dispatchers.Default

actual val developerUrl: String
    get() = "https://apps.apple.com/developer/uzinfocom/id1161112460"

actual val appUrl: String
    get() = "https://apps.apple.com/app/myid-ozbekiston/id1562842955"