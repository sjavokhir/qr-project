package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenWrapper

internal data class GenerateScreen(
    val text: String,
    val type: GenerateType
) : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { GenerateScreenModel() }
        val state by screenModel.state.collectAsState()

        BaseScreenWrapper(screenModel = screenModel) {
            GenerateContent(
                state = state,
                type = type,
                sendEvent = screenModel::sendEvent
            )
        }
    }
}