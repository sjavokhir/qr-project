package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.socialMedia

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class SocialMediaScreenModel : ScreenModel, KoinComponent {

    private val socialMediaStateData = MutableStateFlow(SocialMediaState())
    val socialMediaState = socialMediaStateData.asStateFlow()

    fun onEvent(event: SocialMediaEvent) {
        when (event) {
            is SocialMediaEvent.UsernameChanged -> onValueChanged(username = event.text)
        }
    }

    private fun onValueChanged(username: String) {
        socialMediaStateData.update {
            it.copy(
                username = username,
                isEnabled = username.isNotEmpty()
            )
        }
    }

    fun getGenerateQrCode(): String {
        return socialMediaState.value.username
    }
}