package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

sealed interface DetectionEvent {
    object GetEntryType : DetectionEvent
    object LetsStart : DetectionEvent
}
