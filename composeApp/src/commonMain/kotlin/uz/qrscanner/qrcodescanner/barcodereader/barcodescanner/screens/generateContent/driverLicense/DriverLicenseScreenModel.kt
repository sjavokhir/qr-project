package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.driverLicense

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.removeSeparator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class DriverLicenseScreenModel :
    BaseScreenModel<DriverLicenseState, DriverLicenseEvent>(DriverLicenseState()) {

    override fun onEvent(event: DriverLicenseEvent) {
        when (event) {
            is DriverLicenseEvent.DocumentTypeChanged -> onValueChanged(documentType = event.value)
            is DriverLicenseEvent.FirstNameChanged -> onValueChanged(firstName = event.value)
            is DriverLicenseEvent.MiddleNameChanged -> onValueChanged(middleName = event.value)
            is DriverLicenseEvent.LastNameChanged -> onValueChanged(lastName = event.value)
            is DriverLicenseEvent.GenderChanged -> onValueChanged(gender = event.value)
            is DriverLicenseEvent.AddressStreetChanged -> onValueChanged(addressStreet = event.value)
            is DriverLicenseEvent.AddressCityChanged -> onValueChanged(addressCity = event.value)
            is DriverLicenseEvent.AddressZipChanged -> onValueChanged(addressZip = event.value)
            is DriverLicenseEvent.LicenseNumberChanged -> onValueChanged(licenseNumber = event.value)
            is DriverLicenseEvent.IssueDateChanged -> onValueChanged(issueDate = event.value)
            is DriverLicenseEvent.ExpiryDateChanged -> onValueChanged(expiryDate = event.value)
            is DriverLicenseEvent.BirthDateChanged -> onValueChanged(birthDate = event.value)
            is DriverLicenseEvent.IssuingCountryChanged -> onValueChanged(issuingCountry = event.value)
        }
    }

    private fun onValueChanged(
        documentType: String? = null,
        firstName: String? = null,
        middleName: String? = null,
        lastName: String? = null,
        gender: String? = null,
        addressStreet: String? = null,
        addressCity: String? = null,
        addressZip: String? = null,
        licenseNumber: String? = null,
        issueDate: String? = null,
        expiryDate: String? = null,
        birthDate: String? = null,
        issuingCountry: String? = null
    ) {
        stateData.update {
            val mDocumentType = (documentType ?: it.documentType).removeSeparator()
            val mFirstName = (firstName ?: it.firstName).removeSeparator()
            val mMiddleName = (middleName ?: it.middleName).removeSeparator()
            val mLastName = (lastName ?: it.lastName).removeSeparator()
            val mGender = (gender ?: it.gender).removeSeparator()
            val mAddressStreet = (addressStreet ?: it.addressStreet).removeSeparator()
            val mAddressCity = (addressCity ?: it.addressCity).removeSeparator()
            val mAddressZip = (addressZip ?: it.addressZip).removeSeparator()
            val mLicenseNumber = (licenseNumber ?: it.licenseNumber).removeSeparator()
            val mIssueDate = (issueDate ?: it.issueDate).removeSeparator()
            val mExpiryDate = (expiryDate ?: it.expiryDate).removeSeparator()
            val mBirthDate = (birthDate ?: it.birthDate).removeSeparator()
            val mIssuingCountry = (issuingCountry ?: it.issuingCountry).removeSeparator()

            it.copy(
                documentType = mDocumentType,
                firstName = mFirstName,
                middleName = mMiddleName,
                lastName = mLastName,
                gender = mGender,
                addressStreet = mAddressStreet,
                addressCity = mAddressCity,
                addressZip = mAddressZip,
                licenseNumber = mLicenseNumber,
                issueDate = mIssueDate,
                expiryDate = mExpiryDate,
                birthDate = mBirthDate,
                issuingCountry = mIssuingCountry,
                isEnabled = mDocumentType.isNotEmpty() && mFirstName.isNotEmpty() &&
                        mMiddleName.isNotEmpty() && mLastName.isNotEmpty() &&
                        mGender.isNotEmpty() && mAddressStreet.isNotEmpty() &&
                        mAddressCity.isNotEmpty() && mAddressZip.isNotEmpty() &&
                        mLicenseNumber.isNotEmpty() && mIssueDate.isNotEmpty() &&
                        mExpiryDate.isNotEmpty() && mBirthDate.isNotEmpty() &&
                        mIssuingCountry.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = buildQrContent(),
            formattedContent = buildQrContent()
        )
    }

    private fun buildQrContent(): String {
        return buildString {
            append("Document Type: ${state.value.documentType}\n")
            append("First Name: ${state.value.firstName}\n")
            append("Middle Name: ${state.value.middleName}\n")
            append("Last Name: ${state.value.lastName}\n")
            append("Gender: ${state.value.gender}\n")
            append("Address Street: ${state.value.addressStreet}\n")
            append("Address City: ${state.value.addressCity}\n")
            append("Address Zip: ${state.value.addressZip}\n")
            append("License Number: ${state.value.licenseNumber}\n")
            append("Issue Date: ${state.value.issueDate}\n")
            append("Expiry Date: ${state.value.expiryDate}\n")
            append("Birth Date: ${state.value.birthDate}\n")
            append("Issuing Country: ${state.value.issuingCountry}")
        }
    }
}