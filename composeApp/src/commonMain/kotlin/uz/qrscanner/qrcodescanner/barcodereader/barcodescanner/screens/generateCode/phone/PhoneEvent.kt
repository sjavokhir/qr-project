package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.phone

sealed class PhoneEvent {
    data class PhoneChanged(val text: String) : PhoneEvent()
}
