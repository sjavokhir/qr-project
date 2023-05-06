package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun TextContent(
    screenModel: TextScreenModel,
    onGenerate: (String) -> Unit
) {
    val state = screenModel.textState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.text,
            onValueChange = {
                screenModel.onEvent(TextEvent.TextChanged(it))
            },
            hint = AppStrings.text,
            placeholder = AppStrings.enterText
        )

        AppFilledButton(
            text = AppStrings.actionGenerateQrCode,
            isEnabled = state.isEnabled,
            onClick = { onGenerate(screenModel.getGenerateQrCode()) }
        )
    }
}