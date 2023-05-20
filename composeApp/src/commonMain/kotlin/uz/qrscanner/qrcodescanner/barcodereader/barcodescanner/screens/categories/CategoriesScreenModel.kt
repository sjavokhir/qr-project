package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories

import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.ioDispatcher

class CategoriesScreenModel : BaseScreenModel<CategoriesState, CategoriesEvent>(CategoriesState()) {

    init {
        onEvent(CategoriesEvent.GetCategories)
    }

    override fun onEvent(event: CategoriesEvent) {
        when (event) {
            CategoriesEvent.GetCategories -> getCategories()
        }
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
                add(GenerateType.Sms)
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

            stateData.update { it.copy(categories = categories) }
        }
    }
}