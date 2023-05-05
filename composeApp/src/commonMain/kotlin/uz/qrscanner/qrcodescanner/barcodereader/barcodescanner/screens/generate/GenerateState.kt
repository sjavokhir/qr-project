package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateModel

data class GenerateState(
    val categories: List<GenerateModel> = emptyList()
)
