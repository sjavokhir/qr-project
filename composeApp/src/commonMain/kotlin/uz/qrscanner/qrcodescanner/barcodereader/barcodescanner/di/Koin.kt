package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.database.FavoritesDao
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.AppStore

expect fun platformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            platformModule(),
            sharedModule()
        )
    }

fun sharedModule() = module {
    singleOf(::FavoritesDao)
    singleOf(::AppStore)
}