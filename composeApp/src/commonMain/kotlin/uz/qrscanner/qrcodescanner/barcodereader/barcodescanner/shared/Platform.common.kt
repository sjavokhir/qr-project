package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

expect fun Modifier.notchPadding(): Modifier

expect fun randomUUID(): String

expect val mainDispatcher: MainCoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher

expect val developerUrl: String
expect val appUrl: String