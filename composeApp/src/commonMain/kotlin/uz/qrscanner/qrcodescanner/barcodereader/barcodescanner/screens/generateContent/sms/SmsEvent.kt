package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.sms

sealed interface SmsEvent {
    data class MessageChanged(val value: String) : SmsEvent
    data class PhoneNumberChanged(val value: String) : SmsEvent
}
