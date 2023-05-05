package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

internal object SettingsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val screenModel = rememberScreenModel { SettingsScreenModel() }
        val state = screenModel.settingsState.collectAsState().value

        SettingsContent(
            state = state,
            onNavigateUp = { navigator.pop() },
            onVibrateChecked = {
                screenModel.onEvent(SettingsEvent.VibrateChecked(it))
            },
            onBeepChecked = {
                screenModel.onEvent(SettingsEvent.BeepChecked(it))
            }
        )
    }
}