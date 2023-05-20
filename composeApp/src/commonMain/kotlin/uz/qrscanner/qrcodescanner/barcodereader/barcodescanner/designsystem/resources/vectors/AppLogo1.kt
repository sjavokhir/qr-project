package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.Background
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.theme.Primary

val appLogo1: ImageVector
    get() {
        if (_appLogo1 != null) return _appLogo1!!

        _appLogo1 = Builder(
            name = "ic_logo1",
            defaultWidth = 200.0.dp,
            defaultHeight = 200.0.dp,
            viewportWidth = 512.0f,
            viewportHeight = 512.0f
        ).apply {
            path(
                fill = SolidColor(Background),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(34.0f, 0.0f)
                lineTo(478.0f, 0.0f)
                arcTo(
                    34.0f, 34.0f, 0.0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    x1 = 512.0f,
                    y1 = 34.0f
                )
                lineTo(512.0f, 478.0f)
                arcTo(
                    34.0f, 34.0f, 0.0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    x1 = 478.0f,
                    y1 = 512.0f
                )
                lineTo(34.0f, 512.0f)
                arcTo(
                    34.0f, 34.0f, 0.0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    x1 = 0.0f,
                    y1 = 478.0f
                )
                lineTo(0.0f, 34.0f)
                arcTo(
                    34.0f, 34.0f, 0.0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    x1 = 34.0f,
                    y1 = 0.0f
                )
                close()
            }
            group {
                path(
                    fill = SolidColor(Primary),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(56.0f, 68.5f)
                    curveTo(56.0f, 65.185f, 57.317f, 62.005f, 59.661f, 59.661f)
                    curveTo(62.005f, 57.317f, 65.185f, 56.0f, 68.5f, 56.0f)
                    horizontalLineTo(143.5f)
                    curveTo(146.815f, 56.0f, 149.995f, 57.317f, 152.339f, 59.661f)
                    curveTo(154.683f, 62.005f, 156.0f, 65.185f, 156.0f, 68.5f)
                    curveTo(156.0f, 71.815f, 154.683f, 74.995f, 152.339f, 77.339f)
                    curveTo(149.995f, 79.683f, 146.815f, 81.0f, 143.5f, 81.0f)
                    horizontalLineTo(102.0f)
                    curveTo(90.402f, 81.0f, 81.0f, 90.402f, 81.0f, 102.0f)
                    verticalLineTo(143.5f)
                    curveTo(81.0f, 146.815f, 79.683f, 149.995f, 77.339f, 152.339f)
                    curveTo(74.995f, 154.683f, 71.815f, 156.0f, 68.5f, 156.0f)
                    curveTo(65.185f, 156.0f, 62.005f, 154.683f, 59.661f, 152.339f)
                    curveTo(57.317f, 149.995f, 56.0f, 146.815f, 56.0f, 143.5f)
                    verticalLineTo(68.5f)
                    close()
                    moveTo(356.0f, 68.5f)
                    curveTo(356.0f, 65.185f, 357.317f, 62.005f, 359.661f, 59.661f)
                    curveTo(362.005f, 57.317f, 365.185f, 56.0f, 368.5f, 56.0f)
                    horizontalLineTo(443.5f)
                    curveTo(446.815f, 56.0f, 449.995f, 57.317f, 452.339f, 59.661f)
                    curveTo(454.683f, 62.005f, 456.0f, 65.185f, 456.0f, 68.5f)
                    verticalLineTo(143.5f)
                    curveTo(456.0f, 146.815f, 454.683f, 149.995f, 452.339f, 152.339f)
                    curveTo(449.995f, 154.683f, 446.815f, 156.0f, 443.5f, 156.0f)
                    curveTo(440.185f, 156.0f, 437.005f, 154.683f, 434.661f, 152.339f)
                    curveTo(432.317f, 149.995f, 431.0f, 146.815f, 431.0f, 143.5f)
                    verticalLineTo(102.0f)
                    curveTo(431.0f, 90.402f, 421.598f, 81.0f, 410.0f, 81.0f)
                    horizontalLineTo(368.5f)
                    curveTo(365.185f, 81.0f, 362.005f, 79.683f, 359.661f, 77.339f)
                    curveTo(357.317f, 74.995f, 356.0f, 71.815f, 356.0f, 68.5f)
                    close()
                    moveTo(68.5f, 356.0f)
                    curveTo(71.815f, 356.0f, 74.995f, 357.317f, 77.339f, 359.661f)
                    curveTo(79.683f, 362.005f, 81.0f, 365.185f, 81.0f, 368.5f)
                    verticalLineTo(410.0f)
                    curveTo(81.0f, 421.598f, 90.402f, 431.0f, 102.0f, 431.0f)
                    horizontalLineTo(143.5f)
                    curveTo(146.815f, 431.0f, 149.995f, 432.317f, 152.339f, 434.661f)
                    curveTo(154.683f, 437.005f, 156.0f, 440.185f, 156.0f, 443.5f)
                    curveTo(156.0f, 446.815f, 154.683f, 449.995f, 152.339f, 452.339f)
                    curveTo(149.995f, 454.683f, 146.815f, 456.0f, 143.5f, 456.0f)
                    horizontalLineTo(68.5f)
                    curveTo(65.185f, 456.0f, 62.005f, 454.683f, 59.661f, 452.339f)
                    curveTo(57.317f, 449.995f, 56.0f, 446.815f, 56.0f, 443.5f)
                    verticalLineTo(368.5f)
                    curveTo(56.0f, 365.185f, 57.317f, 362.005f, 59.661f, 359.661f)
                    curveTo(62.005f, 357.317f, 65.185f, 356.0f, 68.5f, 356.0f)
                    close()
                    moveTo(443.5f, 356.0f)
                    curveTo(446.815f, 356.0f, 449.995f, 357.317f, 452.339f, 359.661f)
                    curveTo(454.683f, 362.005f, 456.0f, 365.185f, 456.0f, 368.5f)
                    verticalLineTo(443.5f)
                    curveTo(456.0f, 446.815f, 454.683f, 449.995f, 452.339f, 452.339f)
                    curveTo(449.995f, 454.683f, 446.815f, 456.0f, 443.5f, 456.0f)
                    horizontalLineTo(368.5f)
                    curveTo(365.185f, 456.0f, 362.005f, 454.683f, 359.661f, 452.339f)
                    curveTo(357.317f, 449.995f, 356.0f, 446.815f, 356.0f, 443.5f)
                    curveTo(356.0f, 440.185f, 357.317f, 437.005f, 359.661f, 434.661f)
                    curveTo(362.005f, 432.317f, 365.185f, 431.0f, 368.5f, 431.0f)
                    horizontalLineTo(410.0f)
                    curveTo(421.598f, 431.0f, 431.0f, 421.598f, 431.0f, 410.0f)
                    verticalLineTo(368.5f)
                    curveTo(431.0f, 365.185f, 432.317f, 362.005f, 434.661f, 359.661f)
                    curveTo(437.005f, 357.317f, 440.185f, 356.0f, 443.5f, 356.0f)
                    close()
                    moveTo(156.0f, 168.5f)
                    curveTo(156.0f, 161.596f, 161.596f, 156.0f, 168.5f, 156.0f)
                    curveTo(175.404f, 156.0f, 181.0f, 161.596f, 181.0f, 168.5f)
                    curveTo(181.0f, 175.404f, 175.404f, 181.0f, 168.5f, 181.0f)
                    curveTo(161.596f, 181.0f, 156.0f, 175.404f, 156.0f, 168.5f)
                    close()
                }
                path(
                    fill = SolidColor(Color.White),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(231.0f, 106.0f)
                    horizontalLineTo(106.0f)
                    verticalLineTo(231.0f)
                    horizontalLineTo(231.0f)
                    verticalLineTo(106.0f)
                    close()
                    moveTo(131.0f, 131.0f)
                    horizontalLineTo(206.0f)
                    verticalLineTo(206.0f)
                    horizontalLineTo(131.0f)
                    verticalLineTo(131.0f)
                    close()
                    moveTo(181.0f, 331.0f)
                    horizontalLineTo(156.0f)
                    verticalLineTo(356.0f)
                    horizontalLineTo(181.0f)
                    verticalLineTo(331.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color.White),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(231.0f, 281.0f)
                    horizontalLineTo(106.0f)
                    verticalLineTo(406.0f)
                    horizontalLineTo(231.0f)
                    verticalLineTo(281.0f)
                    close()
                    moveTo(131.0f, 306.0f)
                    horizontalLineTo(206.0f)
                    verticalLineTo(381.0f)
                    horizontalLineTo(131.0f)
                    verticalLineTo(306.0f)
                    close()
                    moveTo(331.0f, 156.0f)
                    horizontalLineTo(356.0f)
                    verticalLineTo(181.0f)
                    horizontalLineTo(331.0f)
                    verticalLineTo(156.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color.White),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(281.0f, 106.0f)
                    horizontalLineTo(406.0f)
                    verticalLineTo(231.0f)
                    horizontalLineTo(281.0f)
                    verticalLineTo(106.0f)
                    close()
                    moveTo(306.0f, 131.0f)
                    verticalLineTo(206.0f)
                    horizontalLineTo(381.0f)
                    verticalLineTo(131.0f)
                    horizontalLineTo(306.0f)
                    close()
                    moveTo(256.0f, 256.0f)
                    verticalLineTo(306.0f)
                    horizontalLineTo(281.0f)
                    verticalLineTo(331.0f)
                    horizontalLineTo(256.0f)
                    verticalLineTo(356.0f)
                    horizontalLineTo(306.0f)
                    verticalLineTo(306.0f)
                    horizontalLineTo(331.0f)
                    verticalLineTo(356.0f)
                    horizontalLineTo(356.0f)
                    verticalLineTo(331.0f)
                    horizontalLineTo(406.0f)
                    verticalLineTo(306.0f)
                    horizontalLineTo(331.0f)
                    verticalLineTo(256.0f)
                    horizontalLineTo(256.0f)
                    close()
                    moveTo(306.0f, 306.0f)
                    horizontalLineTo(281.0f)
                    verticalLineTo(281.0f)
                    horizontalLineTo(306.0f)
                    verticalLineTo(306.0f)
                    close()
                    moveTo(406.0f, 356.0f)
                    horizontalLineTo(381.0f)
                    verticalLineTo(381.0f)
                    horizontalLineTo(331.0f)
                    verticalLineTo(406.0f)
                    horizontalLineTo(406.0f)
                    verticalLineTo(356.0f)
                    close()
                    moveTo(306.0f, 406.0f)
                    verticalLineTo(381.0f)
                    horizontalLineTo(256.0f)
                    verticalLineTo(406.0f)
                    horizontalLineTo(306.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color.White),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(356.0f, 281.0f)
                    horizontalLineTo(406.0f)
                    verticalLineTo(256.0f)
                    horizontalLineTo(356.0f)
                    verticalLineTo(281.0f)
                    close()
                }
                path(
                    fill = SolidColor(Primary),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(168.222f, 168.222f)
                    moveToRelative(-14.444f, 0.0f)
                    arcToRelative(
                        14.444f, 14.444f, 0.0f,
                        isMoreThanHalf = true,
                        isPositiveArc = true,
                        dx1 = 28.889f,
                        dy1 = 0.0f
                    )
                    arcToRelative(
                        14.444f, 14.444f, 0.0f,
                        isMoreThanHalf = true,
                        isPositiveArc = true,
                        dx1 = -28.889f,
                        dy1 = 0.0f
                    )
                }
                path(
                    fill = SolidColor(Primary),
                    stroke = SolidColor(Primary),
                    strokeLineWidth = 8.0f,
                    strokeLineCap = Round,
                    strokeLineJoin = StrokeJoin.Companion.Round,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(63.778f, 256.0f)
                    lineTo(451.556f, 252.667f)
                }
            }
        }.build()

        return _appLogo1!!
    }

private var _appLogo1: ImageVector? = null
