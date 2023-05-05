package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.set
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.EntryType

class AppStore(private val settings: ObservableSettings) {

    fun getEntryType(): EntryType {
        return EntryType.valueOf(settings.getString(Keys.ENTRY_TYPE, EntryType.Idle.name))
    }

    fun setEntryType(type: EntryType) {
        settings[Keys.ENTRY_TYPE] = type.name
    }

    fun isVibrateChecked(): Boolean {
        return settings.getBoolean(Keys.VIBRATE, true)
    }

    fun setVibrateChecked(isChecked: Boolean) {
        settings[Keys.VIBRATE] = isChecked
    }

    fun isBeepChecked(): Boolean {
        return settings.getBoolean(Keys.BEEP, false)
    }

    fun setBeepChecked(isChecked: Boolean) {
        settings[Keys.BEEP] = isChecked
    }
}