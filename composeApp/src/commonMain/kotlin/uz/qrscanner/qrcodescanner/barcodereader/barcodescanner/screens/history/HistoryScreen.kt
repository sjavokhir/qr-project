package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.replaceTo
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings.SettingsScreen

internal object HistoryScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val screenModel = rememberScreenModel { HistoryScreenModel() }
        val state = screenModel.historyState.collectAsState().value

        HistoryContent(
            state = state,
            onNavigationClick = { navigator.replaceTo(it, NavigationType.History) },
            onNavigateToSettings = { navigator.push(SettingsScreen) }
        )
    }
}