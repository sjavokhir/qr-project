package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.selectLocation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GeoPosition
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.MapView

@Composable
fun SelectLocationContent(
    onNavigateUp: () -> Unit,
    onSelectLocation: (GeoPosition) -> Unit
) {
    val currentPosition = rememberSaveable { mutableStateOf(GeoPosition()) }

    AppBackground {
        Column {
            AppTopBar(
                title = AppStrings.selectLocation,
                onNavigationClick = onNavigateUp
            )

            SurfaceContent(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    MapView(currentPosition = currentPosition)

                    AppIcon(
                        imageVector = AppIcons.Pin,
                        modifier = Modifier.size(56.dp)
                    )
                }
            }

            AppFilledButton(
                modifier = Modifier.padding(20.dp),
                text = AppStrings.actionSelect,
                onClick = { onSelectLocation(currentPosition.value) }
            )
        }
    }
}