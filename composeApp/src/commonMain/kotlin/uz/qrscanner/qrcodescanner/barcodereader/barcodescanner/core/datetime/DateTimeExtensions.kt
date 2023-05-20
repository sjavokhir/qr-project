package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun now(): DateTimeModel {
    return Clock.System.now().toDateTimeModel()
}

private fun Instant.toDateTimeModel(): DateTimeModel {
    return toLocalDateTime(TimeZone.currentSystemDefault()).toDateTimeModel()
}

private fun LocalDateTime.toDateTimeModel(): DateTimeModel {
    return DateTimeModel(
        dayOfMonth = dayOfMonth,
        month = monthNumber,
        monthName = month.name,
        weekName = dayOfWeek.name,
        year = year,
        hour = hour,
        minute = minute,
        second = second,
    )
}