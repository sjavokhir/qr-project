package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.wifi

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class WifiScreenModel : ScreenModel, KoinComponent {

    private val wifiStateData = MutableStateFlow(WifiState())
    val wifiState = wifiStateData.asStateFlow()

    fun onEvent(event: WifiEvent) {
        when (event) {
            is WifiEvent.NetworkNameChanged -> onValueChanged(networkName = event.text)
            is WifiEvent.PasswordChanged -> onValueChanged(password = event.text)
        }
    }

    private fun onValueChanged(
        networkName: String? = null,
        password: String? = null
    ) {
        wifiStateData.update {
            it.copy(
                networkName = networkName ?: it.networkName,
                password = password ?: it.password,
                isEnabled = !networkName.isNullOrEmpty() && !password.isNullOrEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return wifiState.value.networkName + wifiState.value.password
    }
}