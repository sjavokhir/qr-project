package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.QrTheme
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories.CategoriesScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection.DetectionScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history.HistoryScreen

@Composable
internal fun App() = QrTheme {
    Navigator(DetectionScreen) { CurrentScreen() }
}

internal fun Navigator.replaceTo(
    navigationType: NavigationType,
    currentNavigationType: NavigationType
) {
    when (navigationType) {
        NavigationType.Generate -> {
            if (navigationType != currentNavigationType) replaceAll(CategoriesScreen)
        }
        NavigationType.Detection -> {
            if (navigationType != currentNavigationType) replaceAll(DetectionScreen)
        }
        NavigationType.History -> {
            if (navigationType != currentNavigationType) replaceAll(HistoryScreen)
        }
    }
}