package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.location

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class LocationScreenModel : BaseScreenModel<LocationState, LocationEvent>(LocationState()) {

    override fun onEvent(event: LocationEvent) {
        when (event) {
            is LocationEvent.LatitudeChanged -> onValueChanged(
                latitude = event.value.toDoubleOrNull()
            )

            is LocationEvent.LongitudeChanged -> onValueChanged(
                longitude = event.value.toDoubleOrNull()
            )

            is LocationEvent.GeoPositionChanged -> onValueChanged(
                latitude = event.value.latitude,
                longitude = event.value.longitude
            )
        }
    }

    private fun onValueChanged(
        latitude: Double? = null,
        longitude: Double? = null
    ) {
        stateData.update {
            val mLatitude = latitude ?: it.latitude
            val mLongitude = longitude ?: it.longitude

            it.copy(
                latitude = mLatitude,
                longitude = mLongitude,
                isEnabled = (mLatitude ?: 0.0) > 0.0 && (mLongitude ?: 0.0) > 0.0
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "geo:${state.value.latitude},${state.value.longitude}",
            formattedContent = """
                ${AppStrings.latitude}: ${state.value.latitude}
                ${AppStrings.longitude}: ${state.value.longitude}
            """.trimIndent()
        )
    }
}