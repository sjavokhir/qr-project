package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.text

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class TextScreenModel : ScreenModel, KoinComponent {

    private val textStateData = MutableStateFlow(TextState())
    val textState = textStateData.asStateFlow()

    fun onEvent(event: TextEvent) {
        when (event) {
            is TextEvent.TextChanged -> onValueChanged(text = event.text)
        }
    }

    private fun onValueChanged(text: String) {
        textStateData.update {
            it.copy(
                text = text,
                isEnabled = text.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return textState.value.text
    }
}