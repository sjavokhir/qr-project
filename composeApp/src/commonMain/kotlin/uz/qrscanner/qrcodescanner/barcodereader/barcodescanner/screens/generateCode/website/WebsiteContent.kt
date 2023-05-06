package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.website

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun WebsiteContent(
    screenModel: WebsiteScreenModel,
    onGenerate: (String) -> Unit
) {
    val state = screenModel.websiteState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.website,
            onValueChange = {
                screenModel.onEvent(WebsiteEvent.WebsiteChanged(it))
            },
            hint = AppStrings.websiteUrl,
            placeholder = AppStrings.googleCom
        )

        AppFilledButton(
            text = AppStrings.actionGenerateQrCode,
            isEnabled = state.isEnabled,
            onClick = { onGenerate(screenModel.getGenerateQrCode()) }
        )
    }
}