package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.Outline
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.UiEvent

@Composable
internal fun GenerateContent(
    state: GenerateState,
    type: GenerateType,
    sendEvent: (UiEvent) -> Unit
) {
    Box {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 100.dp,
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { GenerateInfo(type = type) }
            item { GenerateActions() }
        }

        AppTopBar(
            title = AppStrings.result,
            onNavigationClick = {
                sendEvent(UiEvent.NavigateUp)
            }
        )
    }
}

@Composable
private fun GenerateInfo(type: GenerateType) {
    SurfaceContent {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                AppIcon(
                    imageVector = type.icon,
                    modifier = Modifier.size(36.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = type.title,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.onBackground
                    )
                    Text(
                        text = "16 Dec 2022, 9:30 pm",
                        style = MaterialTheme.typography.caption,
                        color = Outline
                    )
                }
            }

            Divider(color = Outline.copy(alpha = 0.5f))

            Text(
                text = "https://www.youtube.com/watch?v=Zd9g7sKvgIM",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Composable
private fun GenerateActions() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        GenerateButton(
            text = AppStrings.share,
            icon = AppIcons.Share,
            onClick = {}
        )
        GenerateButton(
            text = AppStrings.copy,
            icon = AppIcons.Copy,
            onClick = {}
        )
        GenerateButton(
            text = AppStrings.save,
            icon = AppIcons.Save,
            onClick = {}
        )
    }
}

@Composable
private fun GenerateButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = MaterialTheme.shapes.medium,
                    ambientColor = MaterialTheme.colors.primary,
                    spotColor = MaterialTheme.colors.primary
                )
                .clip(MaterialTheme.shapes.medium)
                .background(color = MaterialTheme.colors.primary)
                .clickable(onClick = onClick)
        ) {
            AppIcon(
                modifier = Modifier
                    .size(34.dp)
                    .align(Alignment.Center),
                imageVector = icon,
                tint = MaterialTheme.colors.background
            )
        }

        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.SemiBold
        )
    }
}
