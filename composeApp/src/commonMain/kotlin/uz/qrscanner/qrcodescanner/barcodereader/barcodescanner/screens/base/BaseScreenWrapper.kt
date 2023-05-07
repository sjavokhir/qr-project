package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.flow.collectLatest
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.replaceTo

@Composable
internal fun <State, ScreenEvent> BaseScreenWrapper(
    screenModel: BaseScreenModel<State, ScreenEvent>,
    content: @Composable () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(key1 = Unit) {
        screenModel.eventChannel.collectLatest { event ->
            when (event) {
                is UiEvent.Message -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is UiEvent.ReplaceTo -> navigator.replaceTo(
                    navigationType = event.navigationType,
                    currentNavigationType = event.currentNavigationType
                )
                is UiEvent.Navigate -> navigator.push(event.screen)
                UiEvent.NavigateUp -> navigator.pop()
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            content()
        }
    }
}