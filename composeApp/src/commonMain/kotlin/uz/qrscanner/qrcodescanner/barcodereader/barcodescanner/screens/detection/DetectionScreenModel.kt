package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.AppStore
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.EntryType

class DetectionScreenModel : ScreenModel, KoinComponent {

    private val appStore by inject<AppStore>()

    private val detectionStateData = MutableStateFlow(DetectionState())
    val detectionState = detectionStateData.asStateFlow()

    init {
        getEntryType()
    }

    fun onEvent(event: DetectionEvent) {
        when (event) {
            DetectionEvent.LetsStart -> setEntryType(EntryType.Dashboard)
        }
    }

    private fun getEntryType() {
        when (val entryType = appStore.getEntryType()) {
            EntryType.Idle -> setEntryType(EntryType.OnBoarding)
            else -> {
                detectionStateData.update { it.copy(entryType = entryType) }
            }
        }
    }

    private fun setEntryType(type: EntryType) {
        appStore.setEntryType(type)
        detectionStateData.update { it.copy(entryType = appStore.getEntryType()) }
    }
}