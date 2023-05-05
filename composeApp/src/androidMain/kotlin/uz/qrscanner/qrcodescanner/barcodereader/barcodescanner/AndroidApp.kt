package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner

import android.app.Application
import org.koin.android.ext.koin.androidContext
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.di.initKoin

class AndroidApp : Application() {

    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        initKoin {
            androidContext(this@AndroidApp)
        }
    }
}