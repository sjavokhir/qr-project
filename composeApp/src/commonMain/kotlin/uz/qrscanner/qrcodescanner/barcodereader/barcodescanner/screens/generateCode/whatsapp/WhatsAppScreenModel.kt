package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.whatsapp

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class WhatsAppScreenModel : ScreenModel, KoinComponent {

    private val whatsAppStateData = MutableStateFlow(WhatsAppState())
    val whatsAppState = whatsAppStateData.asStateFlow()

    fun onEvent(event: WhatsAppEvent) {
        when (event) {
            is WhatsAppEvent.PhoneChanged -> onValueChanged(phone = event.text)
        }
    }

    private fun onValueChanged(phone: String) {
        whatsAppStateData.update {
            it.copy(
                phone = phone,
                isEnabled = phone.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return whatsAppState.value.phone
    }
}