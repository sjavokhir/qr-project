package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.AppStore

class SettingsScreenModel : ScreenModel, KoinComponent {

    private val appStore by inject<AppStore>()

    private val settingsStateData = MutableStateFlow(SettingsState())
    val settingsState = settingsStateData.asStateFlow()

    init {
        getStoreData()
    }

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.VibrateChecked -> onVibrateChecked(event.isChecked)
            is SettingsEvent.BeepChecked -> onBeepChecked(event.isChecked)
        }
    }

    private fun getStoreData() {
        settingsStateData.update {
            it.copy(
                isVibrateChecked = appStore.isVibrateChecked(),
                isBeepChecked = appStore.isBeepChecked()
            )
        }
    }

    private fun onVibrateChecked(isChecked: Boolean) {
        appStore.setVibrateChecked(isChecked)
        settingsStateData.update { it.copy(isVibrateChecked = appStore.isVibrateChecked()) }
    }

    private fun onBeepChecked(isChecked: Boolean) {
        appStore.setBeepChecked(isChecked)
        settingsStateData.update { it.copy(isBeepChecked = appStore.isBeepChecked()) }
    }
}