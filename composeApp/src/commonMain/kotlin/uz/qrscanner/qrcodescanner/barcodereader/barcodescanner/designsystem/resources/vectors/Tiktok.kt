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

val TiktokIcon: ImageVector
    get() {
        if (tiktokIcon != null) return tiktokIcon!!

        tiktokIcon = Builder(
            name = "Tiktok", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(34.1451f, 0.0f)
                horizontalLineTo(26.0556f)
                verticalLineTo(32.6956f)
                curveTo(26.0556f, 36.5913f, 22.9444f, 39.7913f, 19.0725f, 39.7913f)
                curveTo(15.2007f, 39.7913f, 12.0894f, 36.5913f, 12.0894f, 32.6956f)
                curveTo(12.0894f, 28.8696f, 15.1315f, 25.7391f, 18.8651f, 25.6f)
                verticalLineTo(17.3913f)
                curveTo(10.6374f, 17.5304f, 4.0f, 24.2783f, 4.0f, 32.6956f)
                curveTo(4.0f, 41.1827f, 10.7757f, 48.0f, 19.1417f, 48.0f)
                curveTo(27.5075f, 48.0f, 34.2833f, 41.1131f, 34.2833f, 32.6956f)
                verticalLineTo(15.9304f)
                curveTo(37.3255f, 18.1565f, 41.059f, 19.4783f, 45.0f, 19.5479f)
                verticalLineTo(11.3391f)
                curveTo(38.9157f, 11.1304f, 34.1451f, 6.1217f, 34.1451f, 0.0f)
                close()
            }
        }
            .build()
        return tiktokIcon!!
    }

private var tiktokIcon: ImageVector? = null
