package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppBackground
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.Outline
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.UiEvent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.appUrl
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.openUrl
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared.shareText

@Composable
internal fun SettingsContent(
    state: SettingsState,
    onEvent: (SettingsEvent) -> Unit,
    sendEvent: (UiEvent) -> Unit
) {
    AppBackground {
        Box {
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 100.dp,
                    bottom = 20.dp
                ),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    Text(
                        text = AppStrings.settings,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                item {
                    SettingsItemWithCheckbox(
                        title = AppStrings.vibrate,
                        description = AppStrings.vibrateDescription,
                        icon = AppIcons.Vibration,
                        isChecked = state.isVibrateChecked,
                        onChecked = {
                            onEvent(SettingsEvent.VibrateChecked(it))
                        }
                    )
                }
                item {
                    SettingsItemWithCheckbox(
                        title = AppStrings.beep,
                        description = AppStrings.beepDescription,
                        icon = AppIcons.NotificationsActive,
                        isChecked = state.isBeepChecked,
                        onChecked = {
                            onEvent(SettingsEvent.BeepChecked(it))
                        }
                    )
                }
                item { Spacer(modifier = Modifier.height(0.dp)) }
                item {
                    Text(
                        text = AppStrings.support,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                item {
                    SettingsItem(
                        title = AppStrings.rateUs,
                        description = AppStrings.rateUsDescription,
                        icon = AppIcons.Verified,
                        onClick = { openUrl(appUrl) }
                    )
                }
                item {
                    SettingsItem(
                        title = AppStrings.share,
                        description = AppStrings.shareDescription,
                        icon = AppIcons.Share,
                        onClick = { shareText("${AppStrings.onBoardingDescription}\n\n${appUrl}") }
                    )
                }
            }

            AppTopBar(
                title = "",
                onNavigationClick = {
                    sendEvent(UiEvent.NavigateUp)
                }
            )
        }
    }
}

@Composable
private fun SettingsItem(
    title: String,
    description: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    SurfaceContent {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(16.dp)
        ) {
            AppIcon(imageVector = icon)

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.body2,
                    color = Outline
                )
            }
        }
    }
}

@Composable
private fun SettingsItemWithCheckbox(
    title: String,
    description: String,
    icon: ImageVector,
    isChecked: Boolean,
    onChecked: (Boolean) -> Unit
) {
    SurfaceContent {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AppIcon(imageVector = icon)

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.body2,
                    color = Outline
                )
            }

            Switch(
                checked = isChecked,
                onCheckedChange = onChecked,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary,
                    checkedTrackColor = MaterialTheme.colors.primary,
                    uncheckedThumbColor = Outline,
                    uncheckedTrackColor = Outline
                )
            )
        }
    }
}