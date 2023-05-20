package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class TextScreenModel : BaseScreenModel<TextState, TextEvent>(TextState()) {

    override fun onEvent(event: TextEvent) {
        when (event) {
            is TextEvent.TextChanged -> onValueChanged(text = event.text)
        }
    }

    private fun onValueChanged(text: String) {
        stateData.update {
            it.copy(
                text = text,
                isEnabled = text.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = state.value.text,
            formattedContent = state.value.text
        )
    }
}