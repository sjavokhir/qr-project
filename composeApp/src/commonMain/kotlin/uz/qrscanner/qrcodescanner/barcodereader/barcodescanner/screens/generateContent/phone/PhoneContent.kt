package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
fun PhoneContent(
    state: PhoneState,
    isWhatsApp: Boolean,
    onEvent: (PhoneEvent) -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.phone,
            onValueChange = {
                onEvent(PhoneEvent.PhoneChanged(it))
            },
            hint = if (isWhatsApp) {
                "${GenerateType.WhatsApp.title} ${AppStrings.phoneNumber}"
            } else {
                AppStrings.phoneNumber
            },
            placeholder = AppStrings.enterPhoneNumber,
            keyboardType = KeyboardType.Phone
        )

        AppFilledButton(
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}