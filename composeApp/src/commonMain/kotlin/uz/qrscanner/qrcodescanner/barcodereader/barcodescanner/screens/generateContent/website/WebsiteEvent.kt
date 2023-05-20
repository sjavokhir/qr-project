package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website

sealed interface WebsiteEvent {
    data class WebsiteChanged(val value: String) : WebsiteEvent
}
