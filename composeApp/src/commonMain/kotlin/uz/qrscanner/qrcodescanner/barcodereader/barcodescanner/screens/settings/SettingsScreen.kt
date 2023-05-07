package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenWrapper

internal object SettingsScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { SettingsScreenModel() }
        val state by screenModel.state.collectAsState()

        BaseScreenWrapper(screenModel = screenModel) {
            SettingsContent(
                state = state,
                onEvent = screenModel::onEvent,
                sendEvent = screenModel::sendEvent
            )
        }
    }
}