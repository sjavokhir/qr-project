package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model

import cafe.adriel.voyager.core.lifecycle.JavaSerializable

data class QrGenerateContent(
    val qrContent: String,
    val formattedContent: String
) : JavaSerializable
