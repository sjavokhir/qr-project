package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class PhoneScreenModel : BaseScreenModel<PhoneState, PhoneEvent>(PhoneState()) {

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

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "tel:" + state.value.phone,
            formattedContent = state.value.phone
        )
    }
}