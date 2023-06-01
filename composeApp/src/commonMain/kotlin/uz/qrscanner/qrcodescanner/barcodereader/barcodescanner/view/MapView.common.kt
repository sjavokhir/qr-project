package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GeoPosition

@Composable
expect fun MapView(
    modifier: Modifier = Modifier,
    currentPosition: MutableState<GeoPosition>
)