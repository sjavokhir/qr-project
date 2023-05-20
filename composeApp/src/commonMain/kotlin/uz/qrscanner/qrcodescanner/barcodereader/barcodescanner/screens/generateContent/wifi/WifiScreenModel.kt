package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.replaceTrim
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class WifiScreenModel : BaseScreenModel<WifiState, WifiEvent>(WifiState()) {

    override fun onEvent(event: WifiEvent) {
        when (event) {
            is WifiEvent.NetworkNameChanged -> onValueChanged(networkName = event.value)
            is WifiEvent.PasswordChanged -> onValueChanged(password = event.value)
        }
    }

    private fun onValueChanged(
        networkName: String? = null,
        password: String? = null
    ) {
        stateData.update {
            val newNetworkName = networkName ?: it.networkName
            val newPassword = password ?: it.password

            it.copy(
                networkName = newNetworkName,
                password = newPassword,
                isEnabled = newNetworkName
                    .replaceTrim()
                    .isNotEmpty() && newPassword.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "WIFI:S:${state.value.networkName.replaceTrim()}" + ";P:" + state.value.password + ";;",
            formattedContent = """
                ${AppStrings.network}: ${state.value.networkName.replaceTrim()}
                ${AppStrings.password}: ${state.value.password}
            """.trimIndent()
        )
    }
}