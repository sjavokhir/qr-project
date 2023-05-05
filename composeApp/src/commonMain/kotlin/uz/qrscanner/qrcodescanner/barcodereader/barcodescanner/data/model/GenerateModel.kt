package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class GenerateModel(
    val title: String,
    val icon: ImageVector,
    val type: GenerateType
)

enum class GenerateType {
    Text,
    Website,
    Wifi,
    Event,
    Contact,
    Business,
    Location,
    Telephone,
    Email,
    Youtube,
    WhatsApp,
    Instagram,
    Facebook,
    Twitter,
    TikTok,
    Telegram,
    Twitch,
    LinkedIn,
    Github,
    Discord,
}
