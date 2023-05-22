package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.location

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GeoPosition

sealed interface LocationEvent {
    data class LatitudeChanged(val value: String) : LocationEvent
    data class LongitudeChanged(val value: String) : LocationEvent
    data class GeoPositionChanged(val value: GeoPosition) : LocationEvent
}
