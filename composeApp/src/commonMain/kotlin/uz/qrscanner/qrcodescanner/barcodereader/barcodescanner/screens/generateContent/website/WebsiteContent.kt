package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
fun WebsiteContent(
    state: WebsiteState,
    onEvent: (WebsiteEvent) -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppTextField(
            value = state.website,
            onValueChange = {
                onEvent(WebsiteEvent.WebsiteChanged(it))
            },
            hint = AppStrings.websiteUrl,
            placeholder = AppStrings.egGoogle
        )

        AppFilledButton(
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}