package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone

sealed interface PhoneEvent {
    data class PhoneChanged(val value: String) : PhoneEvent
}
