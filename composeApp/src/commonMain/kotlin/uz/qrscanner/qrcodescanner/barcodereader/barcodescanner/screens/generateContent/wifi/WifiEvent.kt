package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

sealed interface WifiEvent {
    data class NetworkNameChanged(val text: String) : WifiEvent
    data class PasswordChanged(val text: String) : WifiEvent
}
