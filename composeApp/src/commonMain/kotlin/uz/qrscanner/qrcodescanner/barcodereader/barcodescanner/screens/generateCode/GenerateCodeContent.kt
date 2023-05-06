package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent

@Composable
internal fun GenerateContent(
    type: GenerateType,
    onNavigateUp: () -> Unit,
    content: @Composable () -> Unit
) {
    AppBackground {
        Column {
            AppTopBar(
                title = type.title,
                onNavigationClick = onNavigateUp
            )

            SurfaceContent(
                modifier = Modifier.padding(20.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        AppIcon(
                            modifier = Modifier.size(60.dp),
                            imageVector = type.icon
                        )
                    }
                    item {
                        content()
                    }
                }
            }
        }
    }
}