package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.removeSeparator
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
            val mNetworkName = (networkName ?: it.networkName).removeSeparator()
            val mPassword = (password ?: it.password).removeSeparator()

            it.copy(
                networkName = mNetworkName,
                password = mPassword,
                isEnabled = mNetworkName.isNotEmpty() && mPassword.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "WIFI:S:${state.value.networkName}" + ";P:" + state.value.password + ";;",
            formattedContent = """
                ${AppStrings.network}: ${state.value.networkName}
                ${AppStrings.password}: ${state.value.password}
            """.trimIndent()
        )
    }
}