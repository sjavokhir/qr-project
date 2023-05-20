package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.replaceSpace
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class PhoneScreenModel(
    private val isWhatsApp: Boolean
) : BaseScreenModel<PhoneState, PhoneEvent>(PhoneState()) {

    override fun onEvent(event: PhoneEvent) {
        when (event) {
            is PhoneEvent.PhoneChanged -> onValueChanged(phone = event.value)
        }
    }

    private fun onValueChanged(phone: String) {
        stateData.update {
            it.copy(
                phone = phone,
                isEnabled = phone
                    .replaceSpace()
                    .isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = (if (isWhatsApp) "https://wa.me/" else "tel:") + state.value.phone.replaceSpace(),
            formattedContent = "${AppStrings.phoneNumber}: " + state.value.phone.replaceSpace()
        )
    }
}