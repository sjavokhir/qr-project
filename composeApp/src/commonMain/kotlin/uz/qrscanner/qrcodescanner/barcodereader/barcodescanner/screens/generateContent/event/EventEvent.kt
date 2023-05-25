package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.event

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.HourMinute

sealed interface EventEvent {
    data class NameChanged(val value: String) : EventEvent
    data class LocationChanged(val value: String) : EventEvent
    data class DescriptionChanged(val value: String) : EventEvent
    data class DateChanged(val value: Long) : EventEvent
    data class TimeChanged(val value: HourMinute) : EventEvent

    data class ShowPicker(val start: Boolean) : EventEvent
    object DismissPicker : EventEvent
}
