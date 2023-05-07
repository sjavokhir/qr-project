package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType

data class CategoriesState(
    val categories: List<GenerateType> = emptyList()
)
