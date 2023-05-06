package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.text

sealed class TextEvent {
    data class TextChanged(val text: String) : TextEvent()
}
