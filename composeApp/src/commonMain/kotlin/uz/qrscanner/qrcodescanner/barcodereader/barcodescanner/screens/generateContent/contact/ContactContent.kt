package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
fun ContactContent(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTextField(
            value = state.firstname,
            onValueChange = {
                onEvent(ContactEvent.FirstNameChanged(it))
            },
            hint = AppStrings.firstname,
            placeholder = AppStrings.enterName
        )

        AppTextField(
            value = state.lastname,
            onValueChange = {
                onEvent(ContactEvent.LastNameChanged(it))
            },
            hint = AppStrings.lastname,
            placeholder = AppStrings.enterName
        )

        AppTextField(
            value = state.phone,
            onValueChange = {
                onEvent(ContactEvent.PhoneChanged(it))
            },
            hint = AppStrings.phoneNumber,
            placeholder = AppStrings.enterPhoneNumber,
            keyboardType = KeyboardType.Phone
        )

        AppTextField(
            value = state.email,
            onValueChange = {
                onEvent(ContactEvent.EmailChanged(it))
            },
            hint = AppStrings.email,
            placeholder = AppStrings.enterEmailAddress,
            keyboardType = KeyboardType.Email
        )

        AppTextField(
            value = state.website,
            onValueChange = {
                onEvent(ContactEvent.WebsiteChanged(it))
            },
            hint = AppStrings.website,
            placeholder = AppStrings.enterWebsite
        )

        AppTextField(
            value = state.address,
            onValueChange = {
                onEvent(ContactEvent.AddressChanged(it))
            },
            hint = AppStrings.address,
            placeholder = AppStrings.enterAddress,
            singleLine = false
        )

        AppFilledButton(
            modifier = Modifier.padding(top = 4.dp),
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}