package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenWrapper

object HistoryScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { HistoryScreenModel() }
        val state by screenModel.state.collectAsState()

        BaseScreenWrapper(screenModel = screenModel) {
            HistoryContent(
                state = state,
                sendEvent = screenModel::sendEvent
            )
        }
    }
}