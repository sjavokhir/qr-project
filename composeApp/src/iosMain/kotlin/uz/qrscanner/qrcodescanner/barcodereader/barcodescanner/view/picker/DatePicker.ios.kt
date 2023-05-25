package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import androidx.compose.runtime.Composable

@Composable
actual fun DatePicker(
    minDate: Long?,
    maxDate: Long?,
    onDateSelected: Long.() -> Unit,
    onDismissRequest: () -> Unit
) {
}