package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text

sealed interface TextEvent {
    data class TextChanged(val value: String) : TextEvent
}
