package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.detection

import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.datastore.AppStore
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.EntryType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class DetectionScreenModel : BaseScreenModel<DetectionState, DetectionEvent>() {

    private val appStore by inject<AppStore>()

    init {
        onEvent(DetectionEvent.GetEntryType)
    }

    override fun defaultState(): DetectionState = DetectionState()

    override fun onEvent(event: DetectionEvent) {
        when (event) {
            DetectionEvent.GetEntryType -> getEntryType()
            DetectionEvent.LetsStart -> setEntryType(EntryType.Dashboard)
        }
    }

    private fun getEntryType() {
        when (val entryType = appStore.getEntryType()) {
            EntryType.Idle -> setEntryType(EntryType.OnBoarding)
            else -> stateData.update { it.copy(entryType = entryType) }
        }
    }

    private fun setEntryType(type: EntryType) {
        appStore.setEntryType(type)
        stateData.update { it.copy(entryType = appStore.getEntryType()) }
    }
}