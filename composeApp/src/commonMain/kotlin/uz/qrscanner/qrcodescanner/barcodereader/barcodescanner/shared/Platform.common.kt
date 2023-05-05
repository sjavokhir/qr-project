package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

expect class PlatformStorableImage

expect fun Modifier.notchPadding(): Modifier

expect fun openUrl(url: String)

expect fun shareText(text: String)

expect fun randomUUID(): String

expect val mainDispatcher: MainCoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher

expect val developerUrl: String
expect val appUrl: String