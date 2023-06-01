package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.driverLicense

data class DriverLicenseState(
    val documentType: String = "",
    val firstName: String = "",
    val middleName: String = "",
    val lastName: String = "",
    val gender: String = "",
    val addressStreet: String = "",
    val addressCity: String = "",
    val addressZip: String = "",
    val licenseNumber: String = "",
    val issueDate: String = "",
    val expiryDate: String = "",
    val birthDate: String = "",
    val issuingCountry: String = "",
    val isEnabled: Boolean = false
)