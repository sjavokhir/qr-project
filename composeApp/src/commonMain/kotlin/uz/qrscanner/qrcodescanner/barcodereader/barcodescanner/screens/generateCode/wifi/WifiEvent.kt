package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.wifi

sealed class WifiEvent {
    data class NetworkNameChanged(val text: String) : WifiEvent()
    data class PasswordChanged(val text: String) : WifiEvent()
}
