package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class HistoryScreenModel : BaseScreenModel<HistoryState, HistoryEvent>(HistoryState()) {

    override fun onEvent(event: HistoryEvent) {
        when (event) {
            HistoryEvent.GetHistory -> Unit
        }
    }
}