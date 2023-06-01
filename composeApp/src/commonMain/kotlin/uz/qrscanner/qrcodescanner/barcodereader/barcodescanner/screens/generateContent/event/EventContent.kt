package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.noRippleClickable
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextField
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.picker.PickerScreen

@Composable
fun EventContent(
    state: EventState,
    onEvent: (EventEvent) -> Unit,
    onGenerate: () -> Unit
) {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppTextField(
            value = state.name,
            onValueChange = {
                onEvent(EventEvent.NameChanged(it))
            },
            hint = AppStrings.eventName,
            placeholder = AppStrings.enterName
        )

        AppTextField(
            value = state.startDateTime,
            onValueChange = {},
            hint = AppStrings.startDateAndTime,
            placeholder = AppStrings.egDateAndTime,
            enabled = false,
            modifier = Modifier.noRippleClickable {
                bottomSheetNavigator.show(PickerScreen(true))
            }
        )

        AppTextField(
            value = state.endDateTime,
            onValueChange = {},
            hint = AppStrings.endDateAndTime,
            placeholder = AppStrings.egDateAndTime,
            enabled = false,
            modifier = Modifier.noRippleClickable {
                bottomSheetNavigator.show(PickerScreen(false))
            }
        )

        AppTextField(
            value = state.location,
            onValueChange = {
                onEvent(EventEvent.LocationChanged(it))
            },
            hint = AppStrings.eventLocation,
            placeholder = AppStrings.enterLocation
        )

        AppTextField(
            value = state.description,
            onValueChange = {
                onEvent(EventEvent.DescriptionChanged(it))
            },
            hint = AppStrings.description,
            placeholder = AppStrings.enterAnyDetails
        )

        AppFilledButton(
            modifier = Modifier.padding(top = 4.dp),
            text = AppStrings.generateQrCode,
            isEnabled = state.isEnabled,
            onClick = onGenerate
        )
    }
}