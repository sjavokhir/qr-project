package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

abstract class BaseScreenModel<State, ScreenEvent> : ScreenModel, KoinComponent {

    protected val stateData = MutableStateFlow(this.defaultState())
    val state = stateData.asStateFlow()

    private val eventChannelData = Channel<UiEvent>()
    val eventChannel = eventChannelData.receiveAsFlow()

    protected abstract fun defaultState(): State

    abstract fun onEvent(event: ScreenEvent)

    fun sendEvent(event: UiEvent) {
        coroutineScope.launch {
            eventChannelData.send(event)
        }
    }
}