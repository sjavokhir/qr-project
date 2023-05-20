package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class SocialMediaScreenModel(private val type: GenerateType) :
    BaseScreenModel<SocialMediaState, SocialMediaEvent>(SocialMediaState()) {

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

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = getQrContent(),
            formattedContent = getQrContent()
        )
    }

    private fun getQrContent(): String {
        return when (type) {
            GenerateType.Youtube -> {
                "https://youtube.com/user/" + state.value.username
            }

            GenerateType.Instagram -> {
                "https://instagram.com/" + state.value.username
            }

            GenerateType.Facebook -> {
                "https://facebook.com/" + state.value.username
            }

            GenerateType.Twitter -> {
                "https://twitter.com/" + state.value.username
            }

            GenerateType.TikTok -> {
                "https://tiktok.com/@" + state.value.username
            }

            GenerateType.Telegram -> {
                "https://t.me/" + state.value.username
            }

            GenerateType.Twitch -> {
                "https://twitch.tv/" + state.value.username
            }

            GenerateType.LinkedIn -> {
                "https://linkedin.com/in/" + state.value.username
            }

            GenerateType.Github -> {
                "https://github.com/" + state.value.username
            }

            else -> {
                ""
            }
        }
    }
}