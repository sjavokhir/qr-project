package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.isEmailValid
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class EmailScreenModel : BaseScreenModel<EmailState, EmailEvent>() {

    override fun defaultState(): EmailState = EmailState()

    override fun onEvent(event: EmailEvent) {
        when (event) {
            is EmailEvent.EmailChanged -> onValueChanged(email = event.text)
        }
    }

    private fun onValueChanged(email: String) {
        stateData.update {
            it.copy(
                email = email,
                isEnabled = email.isEmailValid()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return state.value.email
    }
}