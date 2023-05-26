package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.Outline
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.PlatformImage
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.copyText
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.getImageBitmap
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.shareText
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.rememberQrImage

@Composable
fun GenerateContent(
    content: QrGenerateContent,
    type: GenerateType,
    datetime: String,
    onNavigateUp: () -> Unit
) {
    val platformImage = rememberQrImage(
        content = content.qrContent,
        size = 512,
        padding = 2
    )
    val imageBitmap by remember(platformImage) {
        mutableStateOf(platformImage?.getImageBitmap())
    }

    AppBackground {
        Box {
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 100.dp,
                    bottom = 120.dp
                ),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item { GenerateInfo(content.formattedContent, type, datetime) }

                imageBitmap?.let { bitmap ->
                    item { GenerateQrImage(bitmap) }
                }

                item { GenerateActions(content.formattedContent, platformImage) }
            }

            AppTopBar(
                title = AppStrings.result,
                onNavigationClick = onNavigateUp
            )
        }
    }
}

@Composable
private fun GenerateInfo(
    content: String,
    type: GenerateType,
    datetime: String
) {
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
                        text = datetime,
                        style = MaterialTheme.typography.body2,
                        color = Outline
                    )
                }
            }

            Divider(color = Outline.copy(alpha = 0.5f))

            Text(
                text = content,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Composable
private fun GenerateQrImage(
    imageBitmap: ImageBitmap
) {
    Image(
        bitmap = imageBitmap,
        contentDescription = null,
        modifier = Modifier
            .size(160.dp)
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = 4.dp,
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.medium
            )
    )
}

@Composable
private fun GenerateActions(
    content: String,
    platformImage: PlatformImage?
) {
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
            onClick = { shareText(content) }
        )
        GenerateButton(
            text = AppStrings.copy,
            icon = AppIcons.Copy,
            onClick = { copyText(content) }
        )

        if (platformImage != null) {
            GenerateButton(
                text = AppStrings.save,
                icon = AppIcons.Save,
                onClick = {}
            )
        }
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
