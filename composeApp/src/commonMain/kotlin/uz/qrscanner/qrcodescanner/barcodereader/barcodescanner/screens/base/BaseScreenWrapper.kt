package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.flow.collectLatest
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.replaceTo
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.toast

@Composable
internal fun <State, ScreenEvent> BaseScreenWrapper(
    screenModel: BaseScreenModel<State, ScreenEvent>,
    content: @Composable () -> Unit
) {
    val navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(key1 = Unit) {
        screenModel.eventChannel.collectLatest { event ->
            when (event) {
                is UiEvent.Message -> toast(event.message)
                is UiEvent.ReplaceTo -> navigator.replaceTo(
                    navigationType = event.navigationType,
                    currentNavigationType = event.currentNavigationType
                )
                is UiEvent.Navigate -> navigator.push(event.screen)
                UiEvent.NavigateUp -> navigator.pop()
            }
        }
    }

    AppBackground { content() }
}