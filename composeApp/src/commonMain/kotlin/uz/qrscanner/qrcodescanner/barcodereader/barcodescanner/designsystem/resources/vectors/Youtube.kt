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

internal val YoutubeIcon: ImageVector
    get() {
        if (youtubeIcon != null) return youtubeIcon!!

        youtubeIcon = Builder(
            name = "Youtube", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(47.5219f, 14.4001f)
                curveTo(47.5219f, 14.4001f, 47.0531f, 11.0907f, 45.6094f, 9.6376f)
                curveTo(43.7812f, 7.7251f, 41.7375f, 7.7157f, 40.8f, 7.6032f)
                curveTo(34.0875f, 7.1157f, 24.0094f, 7.1157f, 24.0094f, 7.1157f)
                horizontalLineTo(23.9906f)
                curveTo(23.9906f, 7.1157f, 13.9125f, 7.1157f, 7.2f, 7.6032f)
                curveTo(6.2625f, 7.7157f, 4.2188f, 7.7251f, 2.3906f, 9.6376f)
                curveTo(0.9469f, 11.0907f, 0.4875f, 14.4001f, 0.4875f, 14.4001f)
                curveTo(0.4875f, 14.4001f, 0.0f, 18.2907f, 0.0f, 22.172f)
                verticalLineTo(25.8095f)
                curveTo(0.0f, 29.6907f, 0.4781f, 33.5813f, 0.4781f, 33.5813f)
                curveTo(0.4781f, 33.5813f, 0.9469f, 36.8907f, 2.3812f, 38.3438f)
                curveTo(4.2094f, 40.2563f, 6.6094f, 40.1907f, 7.6781f, 40.397f)
                curveTo(11.5219f, 40.7626f, 24.0f, 40.8751f, 24.0f, 40.8751f)
                curveTo(24.0f, 40.8751f, 34.0875f, 40.8563f, 40.8f, 40.3782f)
                curveTo(41.7375f, 40.2657f, 43.7812f, 40.2563f, 45.6094f, 38.3438f)
                curveTo(47.0531f, 36.8907f, 47.5219f, 33.5813f, 47.5219f, 33.5813f)
                curveTo(47.5219f, 33.5813f, 48.0f, 29.7001f, 48.0f, 25.8095f)
                verticalLineTo(22.172f)
                curveTo(48.0f, 18.2907f, 47.5219f, 14.4001f, 47.5219f, 14.4001f)
                close()
                moveTo(19.0406f, 30.2251f)
                verticalLineTo(16.7345f)
                lineTo(32.0062f, 23.5032f)
                lineTo(19.0406f, 30.2251f)
                close()
            }
        }
            .build()
        return youtubeIcon!!
    }

private var youtubeIcon: ImageVector? = null
