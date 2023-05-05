package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.coroutines.Dispatchers
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.AndroidApp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.tryCatch
import java.util.*

class AndroidStorableImage(
    val imageBitmap: ImageBitmap
)

actual typealias PlatformStorableImage = AndroidStorableImage

actual fun Modifier.notchPadding(): Modifier = this.displayCutoutPadding()
    .statusBarsPadding()
    .navigationBarsPadding()

actual fun openUrl(url: String) {
    tryCatch {
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(url)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        AndroidApp.INSTANCE.startActivity(intent)
    }
}

actual fun shareText(text: String) {
    tryCatch {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        val shareIntent = Intent.createChooser(intent, null).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        AndroidApp.INSTANCE.startActivity(shareIntent)
    }
}

actual fun randomUUID() = UUID.randomUUID().toString()

actual val mainDispatcher = Dispatchers.Main
actual val ioDispatcher = Dispatchers.IO

actual val developerUrl: String
    get() = "https://play.google.com/store/apps/dev?id=7117455902992990244"

actual val appUrl: String
    get() = "https://play.google.com/store/apps/details?id=uz.javokhirdev.duas"