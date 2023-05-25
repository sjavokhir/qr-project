package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import androidx.compose.runtime.Composable

/**
 * A Jetpack Compose compatible Date Picker.
 * @param minDate The minimum date allowed to be picked.
 * @param maxDate The maximum date allowed to be picked.
 * @param onDateSelected Will get called when a date gets picked.
 * @param onDismissRequest Will get called when the user requests to close the dialog.
 */
@Composable
expect fun DatePicker(
    minDate: Long? = null,
    maxDate: Long? = null,
    onDateSelected: Long.() -> Unit,
    onDismissRequest: () -> Unit
)

@Composable
expect fun HourMinutePicker(
    hourMinute: HourMinute = HourMinute(),
    onTimeSelected: HourMinute.() -> Unit,
    onDismissRequest: () -> Unit
)