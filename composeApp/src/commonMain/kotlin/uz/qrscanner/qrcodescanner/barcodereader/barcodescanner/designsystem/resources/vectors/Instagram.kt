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

internal val InstagramIcon: ImageVector
    get() {
        if (instagramIcon != null) return instagramIcon!!

        instagramIcon = Builder(
            name = "Instagram", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(24.0f, 4.3219f)
                    curveTo(30.4125f, 4.3219f, 31.1719f, 4.35f, 33.6938f, 4.4625f)
                    curveTo(36.0375f, 4.5656f, 37.3031f, 4.9594f, 38.1469f, 5.2875f)
                    curveTo(39.2625f, 5.7188f, 40.0688f, 6.2438f, 40.9031f, 7.0781f)
                    curveTo(41.7469f, 7.9219f, 42.2625f, 8.7188f, 42.6938f, 9.8344f)
                    curveTo(43.0219f, 10.6781f, 43.4156f, 11.9531f, 43.5188f, 14.2875f)
                    curveTo(43.6313f, 16.8187f, 43.6594f, 17.5781f, 43.6594f, 23.9813f)
                    curveTo(43.6594f, 30.3938f, 43.6313f, 31.1531f, 43.5188f, 33.675f)
                    curveTo(43.4156f, 36.0188f, 43.0219f, 37.2844f, 42.6938f, 38.1281f)
                    curveTo(42.2625f, 39.2438f, 41.7375f, 40.05f, 40.9031f, 40.8844f)
                    curveTo(40.0594f, 41.7281f, 39.2625f, 42.2438f, 38.1469f, 42.675f)
                    curveTo(37.3031f, 43.0031f, 36.0281f, 43.3969f, 33.6938f, 43.5f)
                    curveTo(31.1625f, 43.6125f, 30.4031f, 43.6406f, 24.0f, 43.6406f)
                    curveTo(17.5875f, 43.6406f, 16.8281f, 43.6125f, 14.3063f, 43.5f)
                    curveTo(11.9625f, 43.3969f, 10.6969f, 43.0031f, 9.8531f, 42.675f)
                    curveTo(8.7375f, 42.2438f, 7.9313f, 41.7188f, 7.0969f, 40.8844f)
                    curveTo(6.2531f, 40.0406f, 5.7375f, 39.2438f, 5.3063f, 38.1281f)
                    curveTo(4.9781f, 37.2844f, 4.5844f, 36.0094f, 4.4812f, 33.675f)
                    curveTo(4.3688f, 31.1438f, 4.3406f, 30.3844f, 4.3406f, 23.9813f)
                    curveTo(4.3406f, 17.5688f, 4.3688f, 16.8094f, 4.4812f, 14.2875f)
                    curveTo(4.5844f, 11.9437f, 4.9781f, 10.6781f, 5.3063f, 9.8344f)
                    curveTo(5.7375f, 8.7188f, 6.2625f, 7.9125f, 7.0969f, 7.0781f)
                    curveTo(7.9406f, 6.2344f, 8.7375f, 5.7188f, 9.8531f, 5.2875f)
                    curveTo(10.6969f, 4.9594f, 11.9719f, 4.5656f, 14.3063f, 4.4625f)
                    curveTo(16.8281f, 4.35f, 17.5875f, 4.3219f, 24.0f, 4.3219f)
                    close()
                    moveTo(24.0f, 0.0f)
                    curveTo(17.4844f, 0.0f, 16.6688f, 0.0281f, 14.1094f, 0.1406f)
                    curveTo(11.5594f, 0.2531f, 9.8062f, 0.6656f, 8.2875f, 1.2563f)
                    curveTo(6.7031f, 1.875f, 5.3625f, 2.6906f, 4.0313f, 4.0313f)
                    curveTo(2.6906f, 5.3625f, 1.875f, 6.7031f, 1.2563f, 8.2781f)
                    curveTo(0.6656f, 9.8062f, 0.2531f, 11.55f, 0.1406f, 14.1f)
                    curveTo(0.0281f, 16.6687f, 0.0f, 17.4844f, 0.0f, 24.0f)
                    curveTo(0.0f, 30.5156f, 0.0281f, 31.3312f, 0.1406f, 33.8906f)
                    curveTo(0.2531f, 36.4406f, 0.6656f, 38.1938f, 1.2563f, 39.7125f)
                    curveTo(1.875f, 41.2969f, 2.6906f, 42.6375f, 4.0313f, 43.9688f)
                    curveTo(5.3625f, 45.3f, 6.7031f, 46.125f, 8.2781f, 46.7344f)
                    curveTo(9.8062f, 47.325f, 11.55f, 47.7375f, 14.1f, 47.85f)
                    curveTo(16.6594f, 47.9625f, 17.475f, 47.9906f, 23.9906f, 47.9906f)
                    curveTo(30.5063f, 47.9906f, 31.3219f, 47.9625f, 33.8813f, 47.85f)
                    curveTo(36.4313f, 47.7375f, 38.1844f, 47.325f, 39.7031f, 46.7344f)
                    curveTo(41.2781f, 46.125f, 42.6188f, 45.3f, 43.95f, 43.9688f)
                    curveTo(45.2812f, 42.6375f, 46.1063f, 41.2969f, 46.7156f, 39.7219f)
                    curveTo(47.3063f, 38.1938f, 47.7188f, 36.45f, 47.8313f, 33.9f)
                    curveTo(47.9438f, 31.3406f, 47.9719f, 30.525f, 47.9719f, 24.0094f)
                    curveTo(47.9719f, 17.4938f, 47.9438f, 16.6781f, 47.8313f, 14.1188f)
                    curveTo(47.7188f, 11.5688f, 47.3063f, 9.8156f, 46.7156f, 8.2969f)
                    curveTo(46.125f, 6.7031f, 45.3094f, 5.3625f, 43.9688f, 4.0313f)
                    curveTo(42.6375f, 2.7f, 41.2969f, 1.875f, 39.7219f, 1.2656f)
                    curveTo(38.1938f, 0.675f, 36.45f, 0.2625f, 33.9f, 0.15f)
                    curveTo(31.3313f, 0.0281f, 30.5156f, 0.0f, 24.0f, 0.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(24.0f, 11.6719f)
                    curveTo(17.1938f, 11.6719f, 11.6719f, 17.1938f, 11.6719f, 24.0f)
                    curveTo(11.6719f, 30.8062f, 17.1938f, 36.3281f, 24.0f, 36.3281f)
                    curveTo(30.8062f, 36.3281f, 36.3281f, 30.8062f, 36.3281f, 24.0f)
                    curveTo(36.3281f, 17.1938f, 30.8062f, 11.6719f, 24.0f, 11.6719f)
                    close()
                    moveTo(24.0f, 31.9969f)
                    curveTo(19.5844f, 31.9969f, 16.0031f, 28.4156f, 16.0031f, 24.0f)
                    curveTo(16.0031f, 19.5844f, 19.5844f, 16.0031f, 24.0f, 16.0031f)
                    curveTo(28.4156f, 16.0031f, 31.9969f, 19.5844f, 31.9969f, 24.0f)
                    curveTo(31.9969f, 28.4156f, 28.4156f, 31.9969f, 24.0f, 31.9969f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(39.6937f, 11.1843f)
                    curveTo(39.6937f, 12.778f, 38.4f, 14.0624f, 36.8156f, 14.0624f)
                    curveTo(35.2219f, 14.0624f, 33.9375f, 12.7687f, 33.9375f, 11.1843f)
                    curveTo(33.9375f, 9.5905f, 35.2313f, 8.3062f, 36.8156f, 8.3062f)
                    curveTo(38.4f, 8.3062f, 39.6937f, 9.5999f, 39.6937f, 11.1843f)
                    close()
                }
            }
        }
            .build()
        return instagramIcon!!
    }

private var instagramIcon: ImageVector? = null
