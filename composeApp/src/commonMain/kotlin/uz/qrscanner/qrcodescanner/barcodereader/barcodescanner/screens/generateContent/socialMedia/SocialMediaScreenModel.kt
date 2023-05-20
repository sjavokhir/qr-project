package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.replaceSpace
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.replaceTrim
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class SocialMediaScreenModel(private val type: GenerateType) :
    BaseScreenModel<SocialMediaState, SocialMediaEvent>(SocialMediaState()) {

    override fun onEvent(event: SocialMediaEvent) {
        when (event) {
            is SocialMediaEvent.UsernameChanged -> onValueChanged(username = event.value)
        }
    }

    private fun onValueChanged(username: String) {
        stateData.update {
            it.copy(
                username = username,
                isEnabled = username
                    .replaceTrim()
                    .replaceSpace()
                    .isNotEmpty()
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
        val link = when (type) {
            GenerateType.Youtube -> "https://youtube.com/user/"
            GenerateType.Instagram -> "https://instagram.com/"
            GenerateType.Facebook -> "https://facebook.com/"
            GenerateType.Twitter -> "https://twitter.com/"
            GenerateType.TikTok -> "https://tiktok.com/@"
            GenerateType.Telegram -> "https://t.me/"
            GenerateType.Twitch -> "https://twitch.tv/"
            GenerateType.LinkedIn -> "https://linkedin.com/in/"
            GenerateType.Github -> "https://github.com/"
            else -> ""
        }

        return link + state.value.username
            .replaceTrim()
            .replaceSpace()
    }
}