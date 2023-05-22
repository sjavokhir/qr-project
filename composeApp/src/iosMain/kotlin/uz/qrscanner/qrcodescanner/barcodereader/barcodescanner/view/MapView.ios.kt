package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.MapKit.MKCoordinateRegionMakeWithDistance
import platform.MapKit.MKMapView
import platform.MapKit.MKPointAnnotation
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GeoPosition
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
actual fun MapView(
    modifier: Modifier,
    currentPosition: MutableState<GeoPosition>
) {
    val location = CLLocationCoordinate2DMake(12.0, 12.0)
    val annotation = remember {
        MKPointAnnotation(
            location,
            title = null,
            subtitle = null
        )
    }
    val mkMapView = remember { MKMapView().apply { addAnnotation(annotation) } }

    annotation.setTitle(AppStrings.selectLocation)

    UIKitView(
        modifier = modifier.fillMaxSize(),
        factory = {
            mkMapView
        },
        update = {
            mkMapView.setRegion(
                MKCoordinateRegionMakeWithDistance(
                    centerCoordinate = location,
                    latitudinalMeters = 10_000.0,
                    longitudinalMeters = 10_000.0
                ),
                animated = false
            )
        }
    )
}