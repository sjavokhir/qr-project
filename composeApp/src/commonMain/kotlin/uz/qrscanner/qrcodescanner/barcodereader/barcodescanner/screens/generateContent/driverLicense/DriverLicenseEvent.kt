package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.driverLicense

sealed interface DriverLicenseEvent {
    data class DocumentTypeChanged(val value: String) : DriverLicenseEvent
    data class FirstNameChanged(val value: String) : DriverLicenseEvent
    data class MiddleNameChanged(val value: String) : DriverLicenseEvent
    data class LastNameChanged(val value: String) : DriverLicenseEvent
    data class GenderChanged(val value: String) : DriverLicenseEvent
    data class AddressStreetChanged(val value: String) : DriverLicenseEvent
    data class AddressCityChanged(val value: String) : DriverLicenseEvent
    data class AddressZipChanged(val value: String) : DriverLicenseEvent
    data class LicenseNumberChanged(val value: String) : DriverLicenseEvent
    data class IssueDateChanged(val value: String) : DriverLicenseEvent
    data class ExpiryDateChanged(val value: String) : DriverLicenseEvent
    data class BirthDateChanged(val value: String) : DriverLicenseEvent
    data class IssuingCountryChanged(val value: String) : DriverLicenseEvent
}
