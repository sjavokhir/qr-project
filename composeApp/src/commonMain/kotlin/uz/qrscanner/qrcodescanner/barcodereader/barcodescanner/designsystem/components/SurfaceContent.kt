package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SurfaceContent(
    modifier: Modifier = Modifier,
    elevation: Dp = 8.dp,
    shape: Shape = MaterialTheme.shapes.medium,
    color: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .shadow(
                elevation = elevation,
                shape = shape,
                ambientColor = color,
                spotColor = color
            )
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(
                    topStart = 9.dp,
                    topEnd = 9.dp,
                    bottomEnd = 7.dp,
                    bottomStart = 7.dp
                )
            )
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 2.dp)
                .clip(shape)
                .background(color = color)
        ) {
            content()
        }
    }
}