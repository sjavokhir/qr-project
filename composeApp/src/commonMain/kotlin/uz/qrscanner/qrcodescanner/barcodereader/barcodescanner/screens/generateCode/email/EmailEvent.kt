package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.email

sealed class EmailEvent {
    data class EmailChanged(val text: String) : EmailEvent()
}
