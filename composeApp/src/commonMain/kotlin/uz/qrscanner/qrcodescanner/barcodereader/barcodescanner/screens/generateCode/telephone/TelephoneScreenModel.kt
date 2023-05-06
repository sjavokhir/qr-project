package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.telephone

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class TelephoneScreenModel : ScreenModel, KoinComponent {

    private val telephoneStateData = MutableStateFlow(TelephoneState())
    val telephoneState = telephoneStateData.asStateFlow()

    fun onEvent(event: TelephoneEvent) {
        when (event) {
            is TelephoneEvent.TelephoneChanged -> onValueChanged(telephone = event.text)
        }
    }

    private fun onValueChanged(telephone: String) {
        telephoneStateData.update {
            it.copy(
                telephone = telephone,
                isEnabled = telephone.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return telephoneState.value.telephone
    }
}