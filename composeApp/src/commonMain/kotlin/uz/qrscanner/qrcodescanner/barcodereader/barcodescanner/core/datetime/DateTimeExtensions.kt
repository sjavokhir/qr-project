package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.HourMinute

fun nowTimestamp(): Long {
    return Clock.System.now().toEpochMilliseconds()
}

fun now(): DateTimeModel {
    return Clock.System.now().toDateTimeModel()
}

fun Long.timestampToDateTime(): DateTimeModel {
    return Instant.fromEpochMilliseconds(this).toDateTimeModel()
}

fun Long.timestampToString(time: HourMinute): String {
    return timestampToDateTime().toInstant(time).toString()
}

private fun DateTimeModel.toInstant(time: HourMinute): Instant {
    return LocalDateTime(
        year = year,
        monthNumber = month,
        dayOfMonth = dayOfMonth,
        hour = time.hourOfDay,
        minute = time.minute,
        second = 0,
        0
    ).toInstant(TimeZone.UTC)
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
        second = second
    )
}