package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.sms

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.removeSpace
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class SmsScreenModel : BaseScreenModel<SmsState, SmsEvent>(SmsState()) {

    override fun onEvent(event: SmsEvent) {
        when (event) {
            is SmsEvent.MessageChanged -> onValueChanged(message = event.value)
            is SmsEvent.PhoneNumberChanged -> onValueChanged(phoneNumber = event.value)
        }
    }

    private fun onValueChanged(
        message: String? = null,
        phoneNumber: String? = null
    ) {
        stateData.update {
            val mMessage = message ?: it.message
            val mPhoneNumber = (phoneNumber ?: it.phoneNumber).removeSpace()

            it.copy(
                message = mMessage,
                phoneNumber = mPhoneNumber,
                isEnabled = mMessage.isNotEmpty() && mPhoneNumber.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "sms:" + state.value.phoneNumber + "?body=" + state.value.message,
            formattedContent = """
                ${AppStrings.message}: ${state.value.message}
                ${AppStrings.phoneNumber}: ${state.value.phoneNumber}
            """.trimIndent()
        )
    }
}