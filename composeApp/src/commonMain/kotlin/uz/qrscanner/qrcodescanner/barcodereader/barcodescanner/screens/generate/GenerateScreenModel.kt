package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.ioDispatcher

class GenerateScreenModel : ScreenModel, KoinComponent {

    private val generateStateData = MutableStateFlow(GenerateState())
    val generateState = generateStateData.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        coroutineScope.launch(ioDispatcher) {
            val categories = buildList {
                add(
                    GenerateModel(
                        title = AppStrings.text,
                        icon = AppIcons.TextFields,
                        type = GenerateType.Text
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.website,
                        icon = AppIcons.Language,
                        type = GenerateType.Website
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.wifi,
                        icon = AppIcons.Wifi,
                        type = GenerateType.Wifi
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.event,
                        icon = AppIcons.Event,
                        type = GenerateType.Event
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.contact,
                        icon = AppIcons.Contacts,
                        type = GenerateType.Contact
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.business,
                        icon = AppIcons.Domain,
                        type = GenerateType.Business
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.location,
                        icon = AppIcons.ShareLocation,
                        type = GenerateType.Location
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.telephone,
                        icon = AppIcons.PhoneCallback,
                        type = GenerateType.Telephone
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.email,
                        icon = AppIcons.Email,
                        type = GenerateType.Email
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.youtube,
                        icon = AppIcons.Youtube,
                        type = GenerateType.Youtube
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.whatsApp,
                        icon = AppIcons.WhatsApp,
                        type = GenerateType.WhatsApp
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.instagram,
                        icon = AppIcons.Instagram,
                        type = GenerateType.Instagram
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.facebook,
                        icon = AppIcons.Facebook,
                        type = GenerateType.Facebook
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.twitter,
                        icon = AppIcons.Twitter,
                        type = GenerateType.Twitter
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.tiktok,
                        icon = AppIcons.Tiktok,
                        type = GenerateType.TikTok
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.telegram,
                        icon = AppIcons.Telegram,
                        type = GenerateType.Telegram
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.twitch,
                        icon = AppIcons.Twitch,
                        type = GenerateType.Twitch
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.linkedin,
                        icon = AppIcons.Linkedin,
                        type = GenerateType.LinkedIn
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.github,
                        icon = AppIcons.Github,
                        type = GenerateType.Github
                    )
                )
                add(
                    GenerateModel(
                        title = AppStrings.discord,
                        icon = AppIcons.Discord,
                        type = GenerateType.Discord
                    )
                )
            }

            generateStateData.update { it.copy(categories = categories) }
        }
    }
}