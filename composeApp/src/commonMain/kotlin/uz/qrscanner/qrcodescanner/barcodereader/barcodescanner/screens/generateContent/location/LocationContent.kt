package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.location

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
fun LocationContent(
    state: LocationState,
    onEvent: (LocationEvent) -> Unit,
    onSelectLocation: () -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTextField(
            value = state.latitude?.toString().orEmpty(),
            onValueChange = {
                onEvent(LocationEvent.LatitudeChanged(it))
            },
            hint = AppStrings.latitude,
            placeholder = AppStrings.enterValue,
            keyboardType = KeyboardType.Decimal
        )

        AppTextField(
            value = state.longitude?.toString().orEmpty(),
            onValueChange = {
                onEvent(LocationEvent.LongitudeChanged(it))
            },
            hint = AppStrings.longitude,
            placeholder = AppStrings.enterValue,
            keyboardType = KeyboardType.Decimal
        )

        AppFilledButton(
            modifier = Modifier.padding(top = 4.dp),
            text = AppStrings.selectLocation,
            onClick = onSelectLocation
        )

        AppFilledButton(
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}