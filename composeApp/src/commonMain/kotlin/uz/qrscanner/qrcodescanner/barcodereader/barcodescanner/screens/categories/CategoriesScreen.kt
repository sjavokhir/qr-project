package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenWrapper

object CategoriesScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { CategoriesScreenModel() }
        val state by screenModel.state.collectAsState()

        BaseScreenWrapper(screenModel = screenModel) {
            CategoriesContent(
                state = state,
                sendEvent = screenModel::sendEvent
            )
        }
    }
}