package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.sms

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
fun SmsContent(
    state: SmsState,
    onEvent: (SmsEvent) -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTextField(
            value = state.message,
            onValueChange = {
                onEvent(SmsEvent.MessageChanged(it))
            },
            hint = AppStrings.message,
            placeholder = AppStrings.enterMessage,
            singleLine = false
        )

        AppTextField(
            value = state.phoneNumber,
            onValueChange = {
                onEvent(SmsEvent.PhoneNumberChanged(it))
            },
            hint = AppStrings.phoneNumber,
            placeholder = AppStrings.enterPhoneNumber,
            keyboardType = KeyboardType.Phone
        )

        AppFilledButton(
            modifier = Modifier.padding(top = 4.dp),
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}