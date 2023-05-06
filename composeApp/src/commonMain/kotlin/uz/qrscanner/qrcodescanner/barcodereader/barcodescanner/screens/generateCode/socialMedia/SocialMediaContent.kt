package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.socialMedia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun SocialMediaContent(
    screenModel: SocialMediaScreenModel,
    type: GenerateType,
    onGenerate: (String) -> Unit
) {
    val state = screenModel.socialMediaState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.username,
            onValueChange = {
                screenModel.onEvent(SocialMediaEvent.UsernameChanged(it))
            },
            hint = AppStrings.username,
            placeholder = AppStrings.enterUsername(type)
        )

        AppFilledButton(
            text = AppStrings.actionGenerateQrCode,
            isEnabled = state.isEnabled,
            onClick = { onGenerate(screenModel.getGenerateQrCode()) }
        )
    }
}