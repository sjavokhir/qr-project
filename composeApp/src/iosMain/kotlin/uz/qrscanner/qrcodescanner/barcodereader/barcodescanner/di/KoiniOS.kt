package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.di

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.ObservableSettings
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.Keys
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.db.AppDatabase

actual fun platformModule() = module {
    single { createSettings() }
    single { AppDatabase(NativeSqliteDriver(AppDatabase.Schema, Keys.APP_DATABASE)) }
}

private fun createSettings(): ObservableSettings {
    val delegate = NSUserDefaults.standardUserDefaults
    return NSUserDefaultsSettings(delegate = delegate)
}