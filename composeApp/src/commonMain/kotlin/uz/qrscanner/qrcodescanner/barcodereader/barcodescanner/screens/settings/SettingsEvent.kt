package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings

sealed class SettingsEvent {
    data class VibrateChecked(val isChecked: Boolean) : SettingsEvent()
    data class BeepChecked(val isChecked: Boolean) : SettingsEvent()
}
