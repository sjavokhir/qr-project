package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.phone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun PhoneContent(
    screenModel: PhoneScreenModel,
    onGenerate: (String) -> Unit
) {
    val state = screenModel.phoneState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.phone,
            onValueChange = {
                screenModel.onEvent(PhoneEvent.PhoneChanged(it))
            },
            hint = AppStrings.phoneNumber,
            placeholder = AppStrings.enterPhoneNumber,
            keyboardType = KeyboardType.Phone
        )

        AppFilledButton(
            text = AppStrings.actionGenerateQrCode,
            isEnabled = state.isEnabled,
            onClick = { onGenerate(screenModel.getGenerateQrCode()) }
        )
    }
}