package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.isUrlValid
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class WebsiteScreenModel : BaseScreenModel<WebsiteState, WebsiteEvent>(WebsiteState()) {

    override fun onEvent(event: WebsiteEvent) {
        when (event) {
            is WebsiteEvent.WebsiteChanged -> onValueChanged(website = event.value)
        }
    }

    private fun onValueChanged(website: String) {
        stateData.update {
            it.copy(
                website = website,
                isEnabled = website.isUrlValid()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = state.value.website,
            formattedContent = "${AppStrings.website}: ${state.value.website}"
        )
    }
}