package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppNavigationBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.UiEvent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings.SettingsScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.QrCameraView
import kotlin.math.absoluteValue

@Composable
internal fun DetectionContent(
    state: DetectionState,
    sendEvent: (UiEvent) -> Unit
) {
    var isFrontCamera by remember { mutableStateOf(false) }

    AppBackground {
        Box {
            QrCameraView(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .align(Alignment.Center)
                    .pointerInput(isFrontCamera) {
                        detectHorizontalDragGestures { _, dragAmount ->
                            if (dragAmount.absoluteValue > 50.0) {
                                isFrontCamera = !isFrontCamera
                            }
                        }
                    },
                isFrontCamera = isFrontCamera,
                onQrResult = {

                }
            )

            Box(
                modifier = Modifier
                    .padding(56.dp)
                    .aspectRatio(1f)
                    .align(Alignment.Center)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = AppIcons.AppLogo3,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

            SurfaceContent(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.TopCenter)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    IconButton(onClick = {}) {
                        AppIcon(imageVector = AppIcons.PhotoLibrary)
                    }
                    IconButton(onClick = {}) {
                        AppIcon(imageVector = AppIcons.FlashOn)
                    }
                    IconButton(onClick = { isFrontCamera = !isFrontCamera }) {
                        AppIcon(imageVector = AppIcons.FlipCameraIos)
                    }
                    IconButton(onClick = { sendEvent(UiEvent.Navigate(SettingsScreen)) }) {
                        AppIcon(imageVector = AppIcons.Settings)
                    }
                }
            }

            AppNavigationBar(
                modifier = Modifier.align(Alignment.BottomCenter),
                currentNavigationType = NavigationType.Detection,
                sendEvent = sendEvent
            )
        }
    }
}