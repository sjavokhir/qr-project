package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.database

import org.koin.core.component.KoinComponent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.db.AppDatabase

class FavoritesDao(database: AppDatabase) : KoinComponent {

    private val queries = database.appDatabaseQueries
}