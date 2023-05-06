package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.email

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.isEmailValid

class EmailScreenModel : ScreenModel, KoinComponent {

    private val emailStateData = MutableStateFlow(EmailState())
    val emailState = emailStateData.asStateFlow()

    fun onEvent(event: EmailEvent) {
        when (event) {
            is EmailEvent.EmailChanged -> onValueChanged(email = event.text)
        }
    }

    private fun onValueChanged(email: String) {
        emailStateData.update {
            it.copy(
                email = email,
                isEnabled = email.isEmailValid()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return emailState.value.email
    }
}