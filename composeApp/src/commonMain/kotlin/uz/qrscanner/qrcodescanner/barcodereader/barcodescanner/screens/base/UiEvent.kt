package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base

import cafe.adriel.voyager.core.screen.Screen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType

sealed interface UiEvent {
    data class Message(val message: String) : UiEvent

    data class ReplaceTo(
        val navigationType: NavigationType,
        val currentNavigationType: NavigationType
    ) : UiEvent

    data class Navigate(val screen: Screen) : UiEvent
    object NavigateUp : UiEvent
}