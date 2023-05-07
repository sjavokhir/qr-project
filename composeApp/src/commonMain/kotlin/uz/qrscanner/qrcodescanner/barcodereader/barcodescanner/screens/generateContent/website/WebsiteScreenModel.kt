package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.isUrlValid
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class WebsiteScreenModel : BaseScreenModel<WebsiteState, WebsiteEvent>() {

    override fun defaultState(): WebsiteState = WebsiteState()

    override fun onEvent(event: WebsiteEvent) {
        when (event) {
            is WebsiteEvent.WebsiteChanged -> onValueChanged(website = event.text)
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

    fun getGenerateQrCode(): String {
        return state.value.website
    }
}