package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model

import androidx.compose.ui.graphics.vector.ImageVector
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

enum class GenerateType(
    val title: String,
    val icon: ImageVector
) {
    Text(AppStrings.text, AppIcons.TextFields),
    Website(AppStrings.website, AppIcons.Language),
    Wifi(AppStrings.wifi, AppIcons.Wifi),
    Event(AppStrings.event, AppIcons.Event),
    Contact(AppStrings.contact, AppIcons.Contacts),
    Business(AppStrings.business, AppIcons.Domain),
    DriverLicense(AppStrings.driverLicense, AppIcons.Car),
    Location(AppStrings.location, AppIcons.ShareLocation),
    Phone(AppStrings.phone, AppIcons.PhoneCallback),
    Sms(AppStrings.sms, AppIcons.Chat),
    Email(AppStrings.email, AppIcons.Email),
    Youtube(AppStrings.youtube, AppIcons.Youtube),
    WhatsApp(AppStrings.whatsApp, AppIcons.WhatsApp),
    Instagram(AppStrings.instagram, AppIcons.Instagram),
    Facebook(AppStrings.facebook, AppIcons.Facebook),
    Twitter(AppStrings.twitter, AppIcons.Twitter),
    TikTok(AppStrings.tiktok, AppIcons.TikTok),
    Telegram(AppStrings.telegram, AppIcons.Telegram),
    Twitch(AppStrings.twitch, AppIcons.Twitch),
    LinkedIn(AppStrings.linkedin, AppIcons.LinkedIn),
    Github(AppStrings.github, AppIcons.Github),
}
