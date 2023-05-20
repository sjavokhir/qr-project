package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FacebookIcon: ImageVector
    get() {
        if (facebookIcon != null) return facebookIcon!!

        facebookIcon = Builder(
            name = "Facebook", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(48.0f, 24.0f)
                    curveTo(48.0f, 10.7452f, 37.2548f, 0.0f, 24.0f, 0.0f)
                    curveTo(10.7452f, 0.0f, 0.0f, 10.7452f, 0.0f, 24.0f)
                    curveTo(0.0f, 35.9789f, 8.7764f, 45.908f, 20.25f, 47.7084f)
                    verticalLineTo(30.9375f)
                    horizontalLineTo(14.1562f)
                    verticalLineTo(24.0f)
                    horizontalLineTo(20.25f)
                    verticalLineTo(18.7125f)
                    curveTo(20.25f, 12.6975f, 23.8331f, 9.375f, 29.3152f, 9.375f)
                    curveTo(31.9402f, 9.375f, 34.6875f, 9.8438f, 34.6875f, 9.8438f)
                    verticalLineTo(15.75f)
                    horizontalLineTo(31.6613f)
                    curveTo(28.68f, 15.75f, 27.75f, 17.6002f, 27.75f, 19.5f)
                    verticalLineTo(24.0f)
                    horizontalLineTo(34.4062f)
                    lineTo(33.3422f, 30.9375f)
                    horizontalLineTo(27.75f)
                    verticalLineTo(47.7084f)
                    curveTo(39.2236f, 45.908f, 48.0f, 35.9789f, 48.0f, 24.0f)
                    close()
                }
            }
        }
            .build()
        return facebookIcon!!
    }

private var facebookIcon: ImageVector? = null
