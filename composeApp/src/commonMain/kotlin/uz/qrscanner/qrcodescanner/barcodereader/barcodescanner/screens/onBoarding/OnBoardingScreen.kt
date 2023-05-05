package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppFilledButton
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
internal fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onLetsStart: () -> Unit
) {
    AppBackground {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    vertical = 36.dp,
                    horizontal = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = AppIcons.AppLogo,
                    contentDescription = AppStrings.appName
                )
            }

            Text(
                text = AppStrings.onBoardingDescription,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground
            )

            AppFilledButton(
                text = AppStrings.actionLetsStart,
                onClick = { onLetsStart() }
            )
        }
    }
}