package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.event

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.HourMinute

sealed interface EventEvent {
    data class NameChanged(val value: String) : EventEvent
    data class LocationChanged(val value: String) : EventEvent
    data class DescriptionChanged(val value: String) : EventEvent
    data class DateChanged(val value: Long, val isStart: Boolean) : EventEvent
    data class TimeChanged(val value: HourMinute, val isStart: Boolean) : EventEvent
}
