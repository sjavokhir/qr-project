package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact

sealed interface ContactEvent {
    data class FirstNameChanged(val value: String) : ContactEvent
    data class LastNameChanged(val value: String) : ContactEvent
    data class PhoneChanged(val value: String) : ContactEvent
    data class EmailChanged(val value: String) : ContactEvent
    data class WebsiteChanged(val value: String) : ContactEvent
    data class AddressChanged(val value: String) : ContactEvent
}
