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

val LinkedinIcon: ImageVector
    get() {
        if (linkedinIcon != null) return linkedinIcon!!

        linkedinIcon = Builder(
            name = "Linkedin", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(44.4469f, 0.0f)
                    horizontalLineTo(3.5438f)
                    curveTo(1.5844f, 0.0f, 0.0f, 1.5469f, 0.0f, 3.4594f)
                    verticalLineTo(44.5312f)
                    curveTo(0.0f, 46.4437f, 1.5844f, 48.0f, 3.5438f, 48.0f)
                    horizontalLineTo(44.4469f)
                    curveTo(46.4062f, 48.0f, 48.0f, 46.4438f, 48.0f, 44.5406f)
                    verticalLineTo(3.4594f)
                    curveTo(48.0f, 1.5469f, 46.4062f, 0.0f, 44.4469f, 0.0f)
                    close()
                    moveTo(14.2406f, 40.9031f)
                    horizontalLineTo(7.1156f)
                    verticalLineTo(17.9906f)
                    horizontalLineTo(14.2406f)
                    verticalLineTo(40.9031f)
                    close()
                    moveTo(10.6781f, 14.8688f)
                    curveTo(8.3906f, 14.8688f, 6.5437f, 13.0219f, 6.5437f, 10.7437f)
                    curveTo(6.5437f, 8.4656f, 8.3906f, 6.6188f, 10.6781f, 6.6188f)
                    curveTo(12.9563f, 6.6188f, 14.8031f, 8.4656f, 14.8031f, 10.7437f)
                    curveTo(14.8031f, 13.0125f, 12.9563f, 14.8688f, 10.6781f, 14.8688f)
                    close()
                    moveTo(40.9031f, 40.9031f)
                    horizontalLineTo(33.7875f)
                    verticalLineTo(29.7656f)
                    curveTo(33.7875f, 27.1125f, 33.7406f, 23.6906f, 30.0844f, 23.6906f)
                    curveTo(26.3812f, 23.6906f, 25.8187f, 26.5875f, 25.8187f, 29.5781f)
                    verticalLineTo(40.9031f)
                    horizontalLineTo(18.7125f)
                    verticalLineTo(17.9906f)
                    horizontalLineTo(25.5375f)
                    verticalLineTo(21.1219f)
                    horizontalLineTo(25.6312f)
                    curveTo(26.5781f, 19.3219f, 28.9031f, 17.4188f, 32.3625f, 17.4188f)
                    curveTo(39.5719f, 17.4188f, 40.9031f, 22.1625f, 40.9031f, 28.3313f)
                    verticalLineTo(40.9031f)
                    close()
                }
            }
        }
            .build()
        return linkedinIcon!!
    }

private var linkedinIcon: ImageVector? = null
