package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.GenerateCodeScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.replaceTo
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings.SettingsScreen

internal object CategoriesScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { CategoriesScreenModel() }
        val state by screenModel.state.collectAsState()

        CategoriesContent(
            state = state,
            sendEvent = screenModel::sendEvent
        )
    }
}