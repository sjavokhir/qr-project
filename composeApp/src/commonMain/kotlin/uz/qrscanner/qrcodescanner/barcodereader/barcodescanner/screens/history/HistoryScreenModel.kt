package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class HistoryScreenModel : BaseScreenModel<HistoryState, HistoryEvent>() {

    override fun defaultState(): HistoryState = HistoryState()

    override fun onEvent(event: HistoryEvent) {
        when (event) {
            HistoryEvent.GetHistory -> Unit
        }
    }
}