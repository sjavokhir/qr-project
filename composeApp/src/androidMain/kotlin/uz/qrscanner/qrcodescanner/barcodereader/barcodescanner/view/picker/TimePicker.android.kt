package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.az
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
actual fun HourMinutePicker(
    hourMinute: HourMinute,
    onTimeSelected: HourMinute.() -> Unit,
    onDismissRequest: () -> Unit
) {
    var selectedTime by remember {
        mutableStateOf<Hours>(
            FullHours(
                hourMinute.hourOfDay,
                hourMinute.minute
            )
        )
    }

    DialogContent(
        title = AppStrings.selectTime,
        selectedText = "${selectedTime.hours.az()}:${selectedTime.minutes.az()}",
        onSelected = {
            onTimeSelected(HourMinute(selectedTime.hours, selectedTime.minutes))
        },
        onDismissRequest = onDismissRequest
    ) {
        HoursNumberPicker(
            value = selectedTime,
            onValueChange = { selectedTime = it },
            hoursDivider = {
                Text(
                    modifier = Modifier.size(24.dp),
                    textAlign = TextAlign.Center,
                    text = ":"
                )
            },
            modifier = Modifier.padding(
                horizontal = 28.dp,
                vertical = 20.dp
            )
        )
    }
}