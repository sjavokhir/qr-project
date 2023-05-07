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
import platform.UIKit.UIApplication

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

actual fun randomUUID(): String =
    CFBridgingRelease(CFUUIDCreateString(null, CFUUIDCreate(null))) as String

actual val mainDispatcher = Dispatchers.Main
actual val ioDispatcher = Dispatchers.Default

actual val developerUrl: String
    get() = "https://apps.apple.com/developer/uzinfocom/id1161112460"

actual val appUrl: String
    get() = "https://apps.apple.com/app/myid-ozbekiston/id1562842955"