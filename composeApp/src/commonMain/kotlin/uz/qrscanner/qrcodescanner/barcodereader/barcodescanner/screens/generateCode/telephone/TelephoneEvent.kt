package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.telephone

sealed class TelephoneEvent {
    data class TelephoneChanged(val text: String) : TelephoneEvent()
}
