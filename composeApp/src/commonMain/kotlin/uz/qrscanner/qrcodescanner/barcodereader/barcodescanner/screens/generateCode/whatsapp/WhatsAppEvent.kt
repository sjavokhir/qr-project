package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.whatsapp

sealed class WhatsAppEvent {
    data class PhoneChanged(val text: String) : WhatsAppEvent()
}
