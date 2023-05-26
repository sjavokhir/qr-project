package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.event

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime.timestampToDateTime
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime.timestampToString
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.removeSeparator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker.HourMinute


class EventScreenModel : BaseScreenModel<EventState, EventEvent>(EventState()) {

    override fun onEvent(event: EventEvent) {
        when (event) {
            is EventEvent.NameChanged -> onValueChanged(name = event.value)
            is EventEvent.LocationChanged -> onValueChanged(location = event.value)
            is EventEvent.DescriptionChanged -> onValueChanged(description = event.value)
            is EventEvent.DateChanged -> onDateChanged(event.value)
            is EventEvent.TimeChanged -> onTimeChanged(event.value)
            is EventEvent.ShowPicker -> showPicker(event.start)
            EventEvent.DismissPicker -> dismissPicker()
        }
    }

    private fun showPicker(start: Boolean) {
        stateData.update {
            it.copy(
                showDatePicker = true,
                showTimePicker = false,
                start = start
            )
        }
    }

    private fun dismissPicker() {
        stateData.update {
            if (it.start) {
                it.copy(
                    showDatePicker = false,
                    showTimePicker = false,
                    startDate = 0L,
                    startTime = HourMinute(),
                    startDateTime = ""
                )
            } else {
                it.copy(
                    showDatePicker = false,
                    showTimePicker = false,
                    endDate = 0L,
                    endTime = HourMinute(),
                    endDateTime = ""
                )
            }
        }
    }

    private fun onDateChanged(date: Long) {
        stateData.update {
            if (it.start) {
                it.copy(
                    showDatePicker = false,
                    showTimePicker = true,
                    startDate = date
                )
            } else {
                it.copy(
                    showDatePicker = false,
                    showTimePicker = true,
                    endDate = date
                )
            }
        }
    }

    private fun onTimeChanged(time: HourMinute) {
        stateData.update {
            if (it.start) {
                it.copy(
                    showDatePicker = false,
                    showTimePicker = false,
                    startTime = time,
                    startDateTime = "${it.startDate.timestampToDateTime().defaultDate}, ${time.defaultTime}",
                )
            } else {
                it.copy(
                    showDatePicker = false,
                    showTimePicker = false,
                    endTime = time,
                    endDateTime = "${it.endDate.timestampToDateTime().defaultDate}, ${time.defaultTime}",
                )
            }
        }
    }

    private fun onValueChanged(
        name: String? = null,
        location: String? = null,
        description: String? = null
    ) {
        stateData.update {
            val mName = (name ?: it.name).removeSeparator()
            val mLocation = (location ?: it.location).removeSeparator()
            val mDescription = (description ?: it.description).removeSeparator()

            it.copy(
                name = mName,
                location = mLocation,
                description = mDescription,
                isEnabled = mName.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = buildQrContent(),
            formattedContent = buildFormattedContent()
        )
    }

    private fun buildQrContent(): String {
        return buildString {
            append("BEGIN:VEVENT\n")
            append("SUMMARY:${currentState.name}\n")
            append("DTSTART:${currentState.startDate.timestampToString(currentState.startTime)}\n")
            append("DTEND:${currentState.endDate.timestampToString(currentState.endTime)}\n")
            append("LOCATION:${currentState.location}\n")
            append("DESCRIPTION:${currentState.description}\n")
            append("END:VEVENT")
        }
    }

    private fun buildFormattedContent(): String {
        return buildString {
            append("Event Name: ${currentState.name}\n")
            append("Start Date and Time: ${currentState.startDateTime}\n")
            append("End Date and Time: ${currentState.endDateTime}\n")
            append("Event Location: ${currentState.location}\n")
            append("Description: ${currentState.description}")
        }
    }
}