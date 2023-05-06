package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType

data class GenerateState(
    val categories: List<GenerateType> = emptyList()
)
