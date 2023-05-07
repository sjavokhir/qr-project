package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate.GenerateScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email.EmailContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email.EmailScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone.PhoneContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone.PhoneScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia.SocialMediaContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia.SocialMediaScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text.TextContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text.TextScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website.WebsiteContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website.WebsiteScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi.WifiContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi.WifiScreenModel

internal data class GenerateCodeScreen(
    val type: GenerateType
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        fun navigateToGenerate(generateText: String) {
            navigator.push(GenerateScreen(generateText, type))
        }

        GenerateCodeContent(
            type = type,
            onNavigateUp = { navigator.pop() },
        ) {
            when (type) {
                GenerateType.Text -> {
                    val screenModel = rememberScreenModel { TextScreenModel() }
                    val state by screenModel.state.collectAsState()

                    TextContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getGenerateQrCode())
                        }
                    )
                }
                GenerateType.Website -> {
                    val screenModel = rememberScreenModel { WebsiteScreenModel() }
                    val state by screenModel.state.collectAsState()

                    WebsiteContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getGenerateQrCode())
                        }
                    )
                }
                GenerateType.Wifi -> {
                    val screenModel = rememberScreenModel { WifiScreenModel() }
                    val state by screenModel.state.collectAsState()

                    WifiContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getGenerateQrCode())
                        }
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
                    val state by screenModel.state.collectAsState()

                    EmailContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getGenerateQrCode())
                        }
                    )
                }
                GenerateType.Phone,
                GenerateType.WhatsApp -> {
                    val screenModel = rememberScreenModel { PhoneScreenModel() }
                    val state by screenModel.state.collectAsState()

                    PhoneContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getGenerateQrCode())
                        }
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
                    val state by screenModel.state.collectAsState()

                    SocialMediaContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        type = type,
                        onGenerate = {
                            navigateToGenerate(screenModel.getGenerateQrCode())
                        }
                    )
                }
            }
        }
    }
}