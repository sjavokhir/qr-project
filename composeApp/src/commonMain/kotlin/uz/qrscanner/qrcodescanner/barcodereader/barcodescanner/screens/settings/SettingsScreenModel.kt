package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings

import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.AppStore
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class SettingsScreenModel : BaseScreenModel<SettingsState, SettingsEvent>() {

    private val appStore by inject<AppStore>()

    init {
        onEvent(SettingsEvent.GetStoreData)
    }

    override fun defaultState(): SettingsState = SettingsState()

    override fun onEvent(event: SettingsEvent) {
        when (event) {
            SettingsEvent.GetStoreData -> getStoreData()
            is SettingsEvent.VibrateChecked -> onVibrateChecked(event.isChecked)
            is SettingsEvent.BeepChecked -> onBeepChecked(event.isChecked)
        }
    }

    private fun getStoreData() {
        stateData.update {
            it.copy(
                isVibrateChecked = appStore.isVibrateChecked(),
                isBeepChecked = appStore.isBeepChecked()
            )
        }
    }

    private fun onVibrateChecked(isChecked: Boolean) {
        appStore.setVibrateChecked(isChecked)
        stateData.update { it.copy(isVibrateChecked = appStore.isVibrateChecked()) }
    }

    private fun onBeepChecked(isChecked: Boolean) {
        appStore.setBeepChecked(isChecked)
        stateData.update { it.copy(isBeepChecked = appStore.isBeepChecked()) }
    }
}