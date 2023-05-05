package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
internal fun AppIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    tint: Color = MaterialTheme.colors.primary
) {
    Icon(
        modifier = modifier,
        imageVector = imageVector,
        contentDescription = null,
        tint = tint
    )
}