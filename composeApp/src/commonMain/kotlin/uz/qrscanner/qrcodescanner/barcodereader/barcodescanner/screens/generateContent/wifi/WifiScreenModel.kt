package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class WifiScreenModel : BaseScreenModel<WifiState, WifiEvent>() {

    override fun defaultState(): WifiState = WifiState()

    override fun onEvent(event: WifiEvent) {
        when (event) {
            is WifiEvent.NetworkNameChanged -> onValueChanged(networkName = event.text)
            is WifiEvent.PasswordChanged -> onValueChanged(password = event.text)
        }
    }

    private fun onValueChanged(
        networkName: String? = null,
        password: String? = null
    ) {
        stateData.update {
            it.copy(
                networkName = networkName ?: it.networkName,
                password = password ?: it.password,
                isEnabled = !networkName.isNullOrEmpty() && !password.isNullOrEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return state.value.networkName + state.value.password
    }
}