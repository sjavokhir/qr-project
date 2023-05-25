package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view.picker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTextButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
fun DialogContent(
    title: String,
    selectedText: String,
    onSelected: () -> Unit,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = MaterialTheme.shapes.large
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onPrimary
                )

                Text(
                    text = selectedText,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onPrimary
                )
            }

            content()

            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AppTextButton(
                    onClick = onDismissRequest,
                    text = AppStrings.cancel
                )

                AppTextButton(
                    onClick = { onSelected() },
                    text = AppStrings.ok,
                    contentColor = MaterialTheme.colors.primary
                )
            }
        }
    }
}