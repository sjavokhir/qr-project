package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.EntryType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenWrapper
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.onBoarding.OnBoardingScreen

object DetectionScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { DetectionScreenModel() }
        val state by screenModel.state.collectAsState()

        BaseScreenWrapper(screenModel = screenModel) {
            when (state.entryType) {
                EntryType.Idle -> {}
                EntryType.OnBoarding -> {
                    OnBoardingScreen(onEvent = screenModel::onEvent)
                }
                EntryType.Dashboard -> {
                    DetectionContent(
                        state = state,
                        sendEvent = screenModel::sendEvent
                    )
                }
            }
        }
    }
}