package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
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
                add(GenerateType.Text)
                add(GenerateType.Website)
                add(GenerateType.Wifi)
                add(GenerateType.Event)
                add(GenerateType.Contact)
                add(GenerateType.Business)
                add(GenerateType.Location)
                add(GenerateType.Phone)
                add(GenerateType.Email)
                add(GenerateType.Youtube)
                add(GenerateType.WhatsApp)
                add(GenerateType.Instagram)
                add(GenerateType.Facebook)
                add(GenerateType.Twitter)
                add(GenerateType.TikTok)
                add(GenerateType.Telegram)
                add(GenerateType.Twitch)
                add(GenerateType.LinkedIn)
                add(GenerateType.Github)
            }

            generateStateData.update { it.copy(categories = categories) }
        }
    }
}