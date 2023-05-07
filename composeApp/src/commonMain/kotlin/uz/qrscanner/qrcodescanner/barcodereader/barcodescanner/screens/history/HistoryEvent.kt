package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

sealed interface HistoryEvent {
    object GetHistory : HistoryEvent
}
