package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.isEmailValid
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class EmailScreenModel : BaseScreenModel<EmailState, EmailEvent>(EmailState()) {

    override fun onEvent(event: EmailEvent) {
        when (event) {
            is EmailEvent.EmailChanged -> onValueChanged(email = event.value)
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

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "mailto:" + currentState.email,
            formattedContent = "${AppStrings.email}: " + currentState.email
        )
    }
}