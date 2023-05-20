package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

sealed interface WifiEvent {
    data class NetworkNameChanged(val value: String) : WifiEvent
    data class PasswordChanged(val value: String) : WifiEvent
}
