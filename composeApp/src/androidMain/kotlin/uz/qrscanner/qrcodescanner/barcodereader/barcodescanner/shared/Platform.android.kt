package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Dispatchers
import java.util.*

actual fun Modifier.notchPadding(): Modifier = this.displayCutoutPadding()
    .statusBarsPadding()
    .navigationBarsPadding()

actual fun randomUUID() = UUID.randomUUID().toString()

actual val mainDispatcher = Dispatchers.Main
actual val ioDispatcher = Dispatchers.IO

actual val developerUrl: String
    get() = "https://play.google.com/store/apps/dev?id=7117455902992990244"

actual val appUrl: String
    get() = "https://play.google.com/store/apps/details?id=uz.javokhirdev.duas"