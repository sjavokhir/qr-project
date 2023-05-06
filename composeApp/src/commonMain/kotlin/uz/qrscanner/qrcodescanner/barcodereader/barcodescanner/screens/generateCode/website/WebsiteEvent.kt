package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.website

sealed class WebsiteEvent {
    data class WebsiteChanged(val text: String) : WebsiteEvent()
}
