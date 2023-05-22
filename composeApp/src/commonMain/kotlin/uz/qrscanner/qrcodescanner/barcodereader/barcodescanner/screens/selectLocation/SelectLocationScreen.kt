package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.selectLocation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GeoPosition
import kotlin.jvm.Transient

data class SelectLocationScreen(
    @Transient private val onSelectLocation: (GeoPosition) -> Unit
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        SelectLocationContent(
            onNavigateUp = { navigator.pop() },
            onSelectLocation = {
                onSelectLocation(it)
                navigator.pop()
            }
        )
    }
}