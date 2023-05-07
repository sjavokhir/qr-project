package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class PhoneScreenModel : BaseScreenModel<PhoneState, PhoneEvent>() {

    override fun defaultState(): PhoneState = PhoneState()

    override fun onEvent(event: PhoneEvent) {
        when (event) {
            is PhoneEvent.PhoneChanged -> onValueChanged(phone = event.text)
        }
    }

    private fun onValueChanged(phone: String) {
        stateData.update {
            it.copy(
                phone = phone,
                isEnabled = phone.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return state.value.phone
    }
}