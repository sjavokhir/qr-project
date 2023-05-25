package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import android.text.format.DateFormat
import android.widget.CalendarView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime.DATE_FORMAT_1
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import java.util.Calendar
import java.util.Date

@Composable
actual fun DatePicker(
    minDate: Long?,
    maxDate: Long?,
    onDateSelected: Long.() -> Unit,
    onDismissRequest: () -> Unit
) {
    val selectedDate = remember { mutableStateOf(Calendar.getInstance().time) }

    DialogContent(
        title = AppStrings.selectDate,
        selectedText = DateFormat.format(DATE_FORMAT_1, selectedDate.value).toString(),
        onSelected = {
            val newDate = selectedDate.value
            onDateSelected(
                maxOf(
                    minOf(maxDate ?: Long.MAX_VALUE, newDate.time),
                    minDate ?: Long.MIN_VALUE
                )
            )
        },
        onDismissRequest = onDismissRequest
    ) {
        CustomCalendarView(
            minDate = minDate,
            maxDate = maxDate,
            onDateSelected = { selectedDate.value = it }
        )
    }
}

/**
 * Used at [DatePicker] to create the calendar picker.
 * @param minDate The minimum date allowed to be picked.
 * @param maxDate The maximum date allowed to be picked.
 * @param onDateSelected Will get called when a date is selected.
 */
@Composable
private fun CustomCalendarView(
    minDate: Long? = null,
    maxDate: Long? = null,
    onDateSelected: (Date) -> Unit
) {
    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = { CalendarView(it) },
        update = { view ->
            if (minDate != null)
                view.minDate = minDate
            if (maxDate != null)
                view.maxDate = maxDate

            view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                onDateSelected(
                    Calendar.getInstance().apply {
                        set(year, month, dayOfMonth)
                    }.time
                )
            }
        }
    )
}