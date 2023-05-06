package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.telephone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun TelephoneContent(
    screenModel: TelephoneScreenModel,
    onGenerate: (String) -> Unit
) {
    val state = screenModel.telephoneState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppFilledButton(
            text = AppStrings.actionGenerateQrCode,
            isEnabled = state.isEnabled,
            onClick = { onGenerate(screenModel.getGenerateQrCode()) }
        )
    }
}