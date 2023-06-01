package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import android.widget.CalendarView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import java.util.Calendar

@Composable
actual fun DatePickerContent(
    minDate: Long?,
    maxDate: Long?,
    onDateSelected: (Long) -> Unit
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
                    }.time.time
                )
            }
        }
    )
}