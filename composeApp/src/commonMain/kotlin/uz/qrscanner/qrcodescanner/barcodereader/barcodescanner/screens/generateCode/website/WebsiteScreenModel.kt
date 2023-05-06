package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.website

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.isUrlValid

class WebsiteScreenModel : ScreenModel, KoinComponent {

    private val websiteStateData = MutableStateFlow(WebsiteState())
    val websiteState = websiteStateData.asStateFlow()

    fun onEvent(event: WebsiteEvent) {
        when (event) {
            is WebsiteEvent.WebsiteChanged -> onValueChanged(website = event.text)
        }
    }

    private fun onValueChanged(website: String) {
        websiteStateData.update {
            it.copy(
                website = website,
                isEnabled = website.isUrlValid()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return websiteState.value.website
    }
}