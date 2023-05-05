package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.di

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.dsl.module
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.Keys
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.db.AppDatabase

actual fun platformModule() = module {
    single { createSettings(get()) }
    single { AppDatabase(AndroidSqliteDriver(AppDatabase.Schema, get(), Keys.APP_DATABASE)) }
}

private fun createSettings(context: Context): ObservableSettings {
    val delegate = context.getSharedPreferences(Keys.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    return SharedPreferencesSettings(delegate = delegate)
}