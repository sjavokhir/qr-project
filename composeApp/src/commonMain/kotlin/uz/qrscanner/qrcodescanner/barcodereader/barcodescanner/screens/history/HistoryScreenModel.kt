package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent

class HistoryScreenModel : ScreenModel, KoinComponent {

    private val historyStateData = MutableStateFlow(HistoryState())
    val historyState = historyStateData.asStateFlow()

    fun onEvent(event: HistoryEvent) {
        when (event) {
            HistoryEvent.Event -> {
            }
        }
    }
}