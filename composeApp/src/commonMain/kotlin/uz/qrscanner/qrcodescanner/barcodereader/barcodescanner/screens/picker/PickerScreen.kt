package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.picker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime.nowTimestamp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.DatePickerContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.FullHours
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.Hours
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.TimePickerContent

data class PickerScreen(
    val isStart: Boolean,
) : Screen {

    @Composable
    override fun Content() {
        var selectedDate by remember { mutableStateOf(nowTimestamp()) }
        var selectedTime by remember {
            mutableStateOf<Hours>(FullHours(9, 0))
        }

        //    PickerContent(
//        title = AppStrings.selectTime,
//        selectedText = "${selectedTime.hours.az()}:${selectedTime.minutes.az()}",
//        onSelected = {
//            onTimeSelected(HourMinute(selectedTime.hours, selectedTime.minutes))
//        }
//    ) {

//    }

        //    PickerContent(
//        title = AppStrings.selectDate,
//        selectedText = DateFormat.format(DATE_FORMAT_1, selectedDate.value).toString(),
//        onSelected = {
//            val newDate = selectedDate.value
//            onDateSelected(
//                maxOf(
//                    minOf(maxDate ?: Long.MAX_VALUE, newDate.time),
//                    minDate ?: Long.MIN_VALUE
//                )
//            )
//        }
//    )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = MaterialTheme.shapes.large
                )
        ) {
            DatePickerContent { selectedDate = it }

            TimePickerContent(
                value = selectedTime,
                onValueChange = { selectedTime = it }
            )

            AppTextButton(
                onClick = {},
                text = AppStrings.ok,
                contentColor = MaterialTheme.colors.primary
            )
        }
    }
}