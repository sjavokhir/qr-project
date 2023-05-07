package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories

sealed interface CategoriesEvent {
    object GetCategories : CategoriesEvent
}