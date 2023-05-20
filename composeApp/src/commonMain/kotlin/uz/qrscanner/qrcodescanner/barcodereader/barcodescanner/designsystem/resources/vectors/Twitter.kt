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

val TwitterIcon: ImageVector
    get() {
        if (twitterIcon != null) return twitterIcon!!

        twitterIcon = Builder(
            name = "Twitter", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(15.1003f, 43.5f)
                    curveTo(33.2091f, 43.5f, 43.1166f, 28.4935f, 43.1166f, 15.4838f)
                    curveTo(43.1166f, 15.0619f, 43.1072f, 14.6307f, 43.0884f, 14.2088f)
                    curveTo(45.0158f, 12.815f, 46.679f, 11.0886f, 48.0f, 9.1107f)
                    curveTo(46.205f, 9.9093f, 44.2993f, 10.4308f, 42.3478f, 10.6575f)
                    curveTo(44.4026f, 9.4259f, 45.9411f, 7.491f, 46.6781f, 5.2116f)
                    curveTo(44.7451f, 6.3572f, 42.6312f, 7.1653f, 40.4269f, 7.6013f)
                    curveTo(38.9417f, 6.0232f, 36.978f, 4.9783f, 34.8394f, 4.6282f)
                    curveTo(32.7008f, 4.278f, 30.5064f, 4.6422f, 28.5955f, 5.6642f)
                    curveTo(26.6846f, 6.6863f, 25.1636f, 8.3095f, 24.2677f, 10.2827f)
                    curveTo(23.3718f, 12.2559f, 23.1509f, 14.4693f, 23.6391f, 16.5807f)
                    curveTo(19.725f, 16.3842f, 15.8959f, 15.3675f, 12.4f, 13.5963f)
                    curveTo(8.904f, 11.825f, 5.8194f, 9.3389f, 3.3459f, 6.2991f)
                    curveTo(2.0888f, 8.4665f, 1.7041f, 11.0314f, 2.2701f, 13.4722f)
                    curveTo(2.836f, 15.9131f, 4.3101f, 18.047f, 6.3928f, 19.44f)
                    curveTo(4.8293f, 19.3904f, 3.2999f, 18.9694f, 1.9312f, 18.2119f)
                    verticalLineTo(18.3338f)
                    curveTo(1.9298f, 20.6084f, 2.7162f, 22.8132f, 4.1566f, 24.5736f)
                    curveTo(5.597f, 26.334f, 7.6027f, 27.5412f, 9.8325f, 27.99f)
                    curveTo(8.3841f, 28.3863f, 6.864f, 28.4441f, 5.3897f, 28.1588f)
                    curveTo(6.0189f, 30.1149f, 7.2432f, 31.8258f, 8.8915f, 33.0527f)
                    curveTo(10.5399f, 34.2796f, 12.5302f, 34.9613f, 14.5847f, 35.0025f)
                    curveTo(11.0968f, 37.7423f, 6.7884f, 39.2283f, 2.3531f, 39.2213f)
                    curveTo(1.5666f, 39.2201f, 0.7808f, 39.1719f, 0.0f, 39.0769f)
                    curveTo(4.5057f, 41.9676f, 9.7471f, 43.5028f, 15.1003f, 43.5f)
                    close()
                }
            }
        }
            .build()
        return twitterIcon!!
    }

private var twitterIcon: ImageVector? = null
