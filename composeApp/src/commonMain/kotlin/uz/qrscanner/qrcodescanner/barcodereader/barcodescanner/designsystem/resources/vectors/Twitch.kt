package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TwitchIcon: ImageVector
    get() {
        if (twitchIcon != null) return twitchIcon!!

        twitchIcon = Builder(
            name = "Twitch", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(12.0015f, 0.0f)
                lineTo(3.43f, 8.5714f)
                verticalLineTo(39.4286f)
                horizontalLineTo(13.7158f)
                verticalLineTo(48.0f)
                lineTo(22.2872f, 39.4286f)
                horizontalLineTo(29.1443f)
                lineTo(44.5729f, 24.0f)
                verticalLineTo(0.0f)
                horizontalLineTo(12.0015f)
                close()
                moveTo(41.1443f, 22.2857f)
                lineTo(34.2872f, 29.1429f)
                horizontalLineTo(27.4301f)
                lineTo(21.4301f, 35.1429f)
                verticalLineTo(29.1429f)
                horizontalLineTo(13.7158f)
                verticalLineTo(3.4286f)
                horizontalLineTo(41.1443f)
                verticalLineTo(22.2857f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(36.0014f, 9.4286f)
                horizontalLineTo(32.5729f)
                verticalLineTo(19.7143f)
                horizontalLineTo(36.0014f)
                verticalLineTo(9.4286f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(26.5727f, 9.4286f)
                horizontalLineTo(23.1442f)
                verticalLineTo(19.7143f)
                horizontalLineTo(26.5727f)
                verticalLineTo(9.4286f)
                close()
            }
        }
            .build()
        return twitchIcon!!
    }

private var twitchIcon: ImageVector? = null
