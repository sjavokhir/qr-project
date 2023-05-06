package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.phone

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class PhoneScreenModel : ScreenModel, KoinComponent {

    private val phoneStateData = MutableStateFlow(PhoneState())
    val phoneState = phoneStateData.asStateFlow()

    fun onEvent(event: PhoneEvent) {
        when (event) {
            is PhoneEvent.PhoneChanged -> onValueChanged(phone = event.text)
        }
    }

    private fun onValueChanged(phone: String) {
        phoneStateData.update {
            it.copy(
                phone = phone,
                isEnabled = phone.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return phoneState.value.phone
    }
}