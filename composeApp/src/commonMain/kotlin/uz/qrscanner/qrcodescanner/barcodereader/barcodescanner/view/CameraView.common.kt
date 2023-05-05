package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.PlatformStorableImage

@Composable
expect fun QrCameraView(
    modifier: Modifier,
    isFrontCamera: Boolean = false,
    onQrResult: () -> Unit
)