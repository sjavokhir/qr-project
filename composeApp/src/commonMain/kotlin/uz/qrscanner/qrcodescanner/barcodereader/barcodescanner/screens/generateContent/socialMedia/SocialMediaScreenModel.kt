package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class SocialMediaScreenModel : BaseScreenModel<SocialMediaState, SocialMediaEvent>() {

    override fun defaultState(): SocialMediaState = SocialMediaState()

    override fun onEvent(event: SocialMediaEvent) {
        when (event) {
            is SocialMediaEvent.UsernameChanged -> onValueChanged(username = event.text)
        }
    }

    private fun onValueChanged(username: String) {
        stateData.update {
            it.copy(
                username = username,
                isEnabled = username.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return state.value.username
    }
}