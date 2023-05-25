package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.event

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.HourMinute

data class EventState(
    val name: String = "",
    val location: String = "",
    val description: String = "",
    val isEnabled: Boolean = false,
    val showDatePicker: Boolean = false,
    val showTimePicker: Boolean = false,
    val start: Boolean = true,
    val startDate: Long = 0L,
    val startTime: HourMinute = HourMinute(),
    val startDateTime: String = "",
    val endDate: Long = 0L,
    val endTime: HourMinute = HourMinute(),
    val endDateTime: String = ""
)