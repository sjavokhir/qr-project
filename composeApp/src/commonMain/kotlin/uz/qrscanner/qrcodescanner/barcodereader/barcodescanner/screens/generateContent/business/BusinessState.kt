package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.business

data class BusinessState(
    val name: String = "",
    val industry: String = "",
    val phone: String = "",
    val email: String = "",
    val website: String = "",
    val address: String = "",
    val isEnabled: Boolean = false
)