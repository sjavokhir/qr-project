package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.email

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
internal fun EmailContent(
    screenModel: EmailScreenModel,
    onGenerate: (String) -> Unit
) {
    val state = screenModel.emailState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.email,
            onValueChange = {
                screenModel.onEvent(EmailEvent.EmailChanged(it))
            },
            hint = AppStrings.email,
            placeholder = AppStrings.enterEmailAddress,
            keyboardType = KeyboardType.Email
        )

        AppFilledButton(
            text = AppStrings.actionGenerateQrCode,
            isEnabled = state.isEnabled,
            onClick = { onGenerate(screenModel.getGenerateQrCode()) }
        )
    }
}