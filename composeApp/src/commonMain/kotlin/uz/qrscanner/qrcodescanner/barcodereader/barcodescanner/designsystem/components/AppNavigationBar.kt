package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun AppNavigationBar(
    modifier: Modifier = Modifier,
    navigationType: NavigationType,
    onClick: (NavigationType) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = if (navigationType == NavigationType.Detection) {
                        listOf(
                            Color.Transparent,
                            Color.Transparent
                        )
                    } else {
                        listOf(
                            Color.Transparent,
                            MaterialTheme.colors.background.copy(alpha = 0.75f),
                            MaterialTheme.colors.background.copy(alpha = 0.95f),
                            MaterialTheme.colors.background
                        )
                    }
                )
            )
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        SurfaceContent {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                NavigationBarItem(
                    imageVector = AppIcons.QrCode,
                    text = AppStrings.generate,
                    isSelected = navigationType == NavigationType.Generate,
                    onClick = { onClick(NavigationType.Generate) }
                )

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = CircleShape,
                            ambientColor = MaterialTheme.colors.primary,
                            spotColor = MaterialTheme.colors.primary
                        )
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.primary)
                        .clickable { onClick(NavigationType.Detection) },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        imageVector = AppIcons.AppLogo2,
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                }

                NavigationBarItem(
                    imageVector = AppIcons.History,
                    text = AppStrings.history,
                    isSelected = navigationType == NavigationType.History,
                    onClick = { onClick(NavigationType.History) }
                )
            }
        }
    }
}

@Composable
private fun NavigationBarItem(
    imageVector: ImageVector,
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppIcon(
            imageVector = imageVector,
            tint = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
            modifier = Modifier.size(26.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}