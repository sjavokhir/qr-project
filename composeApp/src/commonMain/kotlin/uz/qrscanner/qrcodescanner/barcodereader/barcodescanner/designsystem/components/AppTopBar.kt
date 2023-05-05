package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons

@Composable
internal fun AppTopBar(
    title: String,
    onNavigationClick: (() -> Unit)? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.background,
                        MaterialTheme.colors.background.copy(alpha = 0.95f),
                        MaterialTheme.colors.background.copy(alpha = 0.75f),
                        Color.Transparent
                    )
                )
            )
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        if (onNavigationClick != null) {
            NavigationButton(
                imageVector = AppIcons.ArrowBack,
                onClick = onNavigationClick
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.weight(1f)
        )

        if (trailingIcon != null) {
            NavigationButton(
                imageVector = trailingIcon,
                onClick = { onTrailingIconClick?.invoke() }
            )
        }
    }
}

@Composable
private fun NavigationButton(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(36.dp)
            .height(42.dp)
            .shadow(
                elevation = 8.dp,
                shape = MaterialTheme.shapes.small,
                ambientColor = MaterialTheme.colors.surface,
                spotColor = MaterialTheme.colors.surface
            )
            .clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colors.surface)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        AppIcon(
            imageVector = imageVector,
            modifier = Modifier.size(22.dp)
        )
    }
}