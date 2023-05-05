import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.di.initKoin
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.App

fun MainViewController(): UIViewController {

    initKoin()

    return ComposeUIViewController { App() }
}
