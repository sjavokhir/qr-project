package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime.now
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent

data class GenerateScreen(
    val content: QrGenerateContent,
    val type: GenerateType
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        GenerateContent(
            content = content,
            type = type,
            datetime = now().defaultDateTime,
            onNavigateUp = { navigator.pop() },
        )
    }
}