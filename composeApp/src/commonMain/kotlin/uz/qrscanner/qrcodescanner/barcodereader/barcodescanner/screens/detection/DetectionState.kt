package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.EntryType

data class DetectionState(
    val entryType: EntryType = EntryType.Idle
)
