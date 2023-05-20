package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.sms

data class SmsState(
    val message: String = "",
    val phoneNumber: String = "",
    val isEnabled: Boolean = false
)
