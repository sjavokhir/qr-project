package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.useContents
import platform.CoreLocation.CLLocation
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.kCLLocationAccuracyBest
import platform.MapKit.MKCoordinateRegionMakeWithDistance
import platform.MapKit.MKMapView
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GeoPosition

@Composable
actual fun MapView(
    modifier: Modifier,
    currentPosition: MutableState<GeoPosition>
) {
    val locationManager = remember {
        CLLocationManager().apply {
            desiredAccuracy = kCLLocationAccuracyBest
            requestWhenInUseAuthorization()
        }
    }
    val location = remember(locationManager.location) {
        val geoPosition = locationManager.location?.toGeo() ?: GeoPosition()
        CLLocationCoordinate2DMake(geoPosition.latitude, geoPosition.longitude)
    }
    val mkMapView = remember { MKMapView() }

    UIKitView(
        modifier = modifier.fillMaxSize(),
        factory = {
            mkMapView
        },
        update = {
            mkMapView.setRegion(
                MKCoordinateRegionMakeWithDistance(
                    centerCoordinate = location,
                    latitudinalMeters = 1_000.0,
                    longitudinalMeters = 1_000.0
                ),
                animated = false
            )
        }
    )
}

private fun CLLocation.toGeo() =
    GeoPosition(
        latitude = coordinate.useContents { latitude },
        longitude = coordinate.useContents { longitude }
    )