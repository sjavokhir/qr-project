package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun WifiContent(
    state: WifiState,
    onEvent: (WifiEvent) -> Unit,
    onGenerate: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTextField(
            value = state.networkName,
            onValueChange = {
                onEvent(WifiEvent.NetworkNameChanged(it))
            },
            hint = AppStrings.network,
            placeholder = AppStrings.enterNetworkName
        )

        AppTextField(
            value = state.password,
            onValueChange = {
                onEvent(WifiEvent.PasswordChanged(it))
            },
            hint = AppStrings.password,
            placeholder = AppStrings.enterPassword,
            keyboardType = KeyboardType.Password
        )

        AppFilledButton(
            modifier = Modifier.padding(top = 4.dp),
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}