package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.driverLicense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
fun DriverLicenseContent(
    state: DriverLicenseState,
    onEvent: (DriverLicenseEvent) -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTextField(
            value = state.documentType,
            onValueChange = {
                onEvent(DriverLicenseEvent.DocumentTypeChanged(it))
            },
            hint = AppStrings.documentType,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.firstName,
            onValueChange = {
                onEvent(DriverLicenseEvent.FirstNameChanged(it))
            },
            hint = AppStrings.firstName,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.middleName,
            onValueChange = {
                onEvent(DriverLicenseEvent.MiddleNameChanged(it))
            },
            hint = AppStrings.middleName,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.lastName,
            onValueChange = {
                onEvent(DriverLicenseEvent.LastNameChanged(it))
            },
            hint = AppStrings.lastName,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.gender,
            onValueChange = {
                onEvent(DriverLicenseEvent.GenderChanged(it))
            },
            hint = AppStrings.gender,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.addressStreet,
            onValueChange = {
                onEvent(DriverLicenseEvent.AddressStreetChanged(it))
            },
            hint = AppStrings.addressStreet,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.addressCity,
            onValueChange = {
                onEvent(DriverLicenseEvent.AddressCityChanged(it))
            },
            hint = AppStrings.addressCity,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.addressZip,
            onValueChange = {
                onEvent(DriverLicenseEvent.AddressZipChanged(it))
            },
            hint = AppStrings.addressZip,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.licenseNumber,
            onValueChange = {
                onEvent(DriverLicenseEvent.LicenseNumberChanged(it))
            },
            hint = AppStrings.licenseNumber,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.issueDate,
            onValueChange = {
                onEvent(DriverLicenseEvent.IssueDateChanged(it))
            },
            hint = AppStrings.issueDate,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.expiryDate,
            onValueChange = {
                onEvent(DriverLicenseEvent.ExpiryDateChanged(it))
            },
            hint = AppStrings.expiryDate,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.birthDate,
            onValueChange = {
                onEvent(DriverLicenseEvent.BirthDateChanged(it))
            },
            hint = AppStrings.birthDate,
            placeholder = AppStrings.enterValue
        )

        AppTextField(
            value = state.issuingCountry,
            onValueChange = {
                onEvent(DriverLicenseEvent.IssuingCountryChanged(it))
            },
            hint = AppStrings.issuingCountry,
            placeholder = AppStrings.enterValue
        )

        AppFilledButton(
            modifier = Modifier.padding(top = 4.dp),
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}