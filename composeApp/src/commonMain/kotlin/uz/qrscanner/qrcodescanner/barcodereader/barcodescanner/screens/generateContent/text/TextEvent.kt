package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text

sealed interface TextEvent {
    data class TextChanged(val text: String) : TextEvent
}
