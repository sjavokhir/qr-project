package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.EntryType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.onBoarding.OnBoardingScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.replaceTo
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings.SettingsScreen

internal object DetectionScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val screenModel = rememberScreenModel { DetectionScreenModel() }
        val state = screenModel.detectionState.collectAsState().value

        when (state.entryType) {
            EntryType.Idle -> {}
            EntryType.OnBoarding -> {
                OnBoardingScreen { screenModel.onEvent(DetectionEvent.LetsStart) }
            }
            EntryType.Dashboard -> {
                DetectionContent(
                    state = state,
                    onNavigationClick = { navigator.replaceTo(it, NavigationType.Detection) },
                    onNavigateToSettings = { navigator.push(SettingsScreen) }
                )
            }
        }
    }
}