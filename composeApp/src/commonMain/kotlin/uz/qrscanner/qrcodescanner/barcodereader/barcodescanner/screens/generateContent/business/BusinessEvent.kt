package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.business

sealed interface BusinessEvent {
    data class NameChanged(val value: String) : BusinessEvent
    data class IndustryChanged(val value: String) : BusinessEvent
    data class PhoneChanged(val value: String) : BusinessEvent
    data class EmailChanged(val value: String) : BusinessEvent
    data class WebsiteChanged(val value: String) : BusinessEvent
    data class AddressChanged(val value: String) : BusinessEvent
}
