package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.Outline

@Composable
internal fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.body1.copy(
            color = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        cursorBrush = Brush.horizontalGradient(colors = listOf(Outline, Outline)),
        decorationBox = { innerTextField ->
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .background(color = MaterialTheme.colors.background.copy(alpha = 0.75f))
                        .border(
                            width = 1.dp,
                            color = Outline.copy(alpha = 0.7f),
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(16.dp)
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.body1,
                            color = Outline.copy(alpha = 0.7f)
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}