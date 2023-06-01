package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import androidx.compose.runtime.Composable
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.az

sealed interface Hours {
    val hours: Int
    val minutes: Int
}

data class HourMinute(
    val hourOfDay: Int = 9,
    val minute: Int = 0
) {
    val defaultTime = "${hourOfDay.az()}:${minute.az()}"
}

data class FullHours(
    override val hours: Int,
    override val minutes: Int,
) : Hours

data class AMPMHours(
    override val hours: Int,
    override val minutes: Int,
    val dayTime: DayTime
) : Hours {
    enum class DayTime {
        AM,
        PM;
    }
}

@Composable
expect fun DatePickerContent(
    minDate: Long? = null,
    maxDate: Long? = null,
    onDateSelected: (Long) -> Unit
)

@Composable
expect fun TimePickerContent(
    value: Hours,
    onValueChange: (Hours) -> Unit
)