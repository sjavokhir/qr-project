package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.email.EmailContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.email.EmailScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.phone.PhoneContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.phone.PhoneScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.socialMedia.SocialMediaContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.socialMedia.SocialMediaScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.text.TextContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.text.TextScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.website.WebsiteContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.website.WebsiteScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.wifi.WifiContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.wifi.WifiScreenModel

internal data class GenerateCodeScreen(
    val type: GenerateType
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        GenerateContent(
            type = type,
            onNavigateUp = { navigator.pop() },
        ) {
            when (type) {
                GenerateType.Text -> {
                    val screenModel = rememberScreenModel { TextScreenModel() }
                    TextContent(
                        screenModel = screenModel,
                        onGenerate = { navigateToResult(it, type) }
                    )
                }
                GenerateType.Website -> {
                    val screenModel = rememberScreenModel { WebsiteScreenModel() }
                    WebsiteContent(
                        screenModel = screenModel,
                        onGenerate = { navigateToResult(it, type) }
                    )
                }
                GenerateType.Wifi -> {
                    val screenModel = rememberScreenModel { WifiScreenModel() }
                    WifiContent(
                        screenModel = screenModel,
                        onGenerate = { navigateToResult(it, type) }
                    )
                }
                GenerateType.Event -> {
                    Spacer(modifier = Modifier.height(56.dp))
                }
                GenerateType.Contact -> {
                    Spacer(modifier = Modifier.height(56.dp))
                }
                GenerateType.Business -> {
                    Spacer(modifier = Modifier.height(56.dp))
                }
                GenerateType.Location -> {
                    Spacer(modifier = Modifier.height(56.dp))
                }
                GenerateType.Email -> {
                    val screenModel = rememberScreenModel { EmailScreenModel() }
                    EmailContent(
                        screenModel = screenModel,
                        onGenerate = { navigateToResult(it, type) }
                    )
                }
                GenerateType.Phone,
                GenerateType.WhatsApp -> {
                    val screenModel = rememberScreenModel { PhoneScreenModel() }
                    PhoneContent(
                        screenModel = screenModel,
                        onGenerate = { navigateToResult(it, type) }
                    )
                }
                GenerateType.Youtube,
                GenerateType.Instagram,
                GenerateType.Facebook,
                GenerateType.Twitter,
                GenerateType.TikTok,
                GenerateType.Telegram,
                GenerateType.Twitch,
                GenerateType.LinkedIn,
                GenerateType.Github -> {
                    val screenModel = rememberScreenModel { SocialMediaScreenModel() }
                    SocialMediaContent(
                        screenModel = screenModel,
                        type = type,
                        onGenerate = { navigateToResult(it, type) }
                    )
                }
            }
        }
    }

    private fun navigateToResult(text: String, type: GenerateType) {
    }
}