package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email

sealed interface EmailEvent {
    data class EmailChanged(val value: String) : EmailEvent
}
