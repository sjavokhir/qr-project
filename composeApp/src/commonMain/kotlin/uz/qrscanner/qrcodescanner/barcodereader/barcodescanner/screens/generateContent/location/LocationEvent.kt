package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.location

sealed interface LocationEvent {
    data class LatitudeChanged(val value: String) : LocationEvent
    data class LongitudeChanged(val value: String) : LocationEvent
}
