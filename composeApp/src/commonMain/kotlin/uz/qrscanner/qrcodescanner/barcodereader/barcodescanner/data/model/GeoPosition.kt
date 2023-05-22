package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model

import cafe.adriel.voyager.core.lifecycle.JavaSerializable

data class GeoPosition(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
): JavaSerializable