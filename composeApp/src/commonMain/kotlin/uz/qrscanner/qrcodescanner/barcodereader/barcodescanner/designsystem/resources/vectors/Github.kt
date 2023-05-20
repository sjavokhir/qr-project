package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val GithubIcon: ImageVector
    get() {
        if (githubIcon != null) return githubIcon!!

        githubIcon = Builder(
            name = "Github", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd
                ) {
                    moveTo(24.0005f, 1.0f)
                    curveTo(18.303f, 1.003f, 12.7923f, 3.0209f, 8.4537f, 6.693f)
                    curveTo(4.1152f, 10.3652f, 1.2318f, 15.452f, 0.3191f, 21.044f)
                    curveTo(-0.5936f, 26.636f, 0.5239f, 32.3684f, 3.4717f, 37.2164f)
                    curveTo(6.4196f, 42.0643f, 11.0057f, 45.7115f, 16.4099f, 47.5059f)
                    curveTo(17.6021f, 47.7272f, 18.0512f, 46.9883f, 18.0512f, 46.36f)
                    curveTo(18.0512f, 45.7317f, 18.0273f, 43.91f, 18.0194f, 41.9184f)
                    curveTo(11.3428f, 43.3608f, 9.932f, 39.101f, 9.932f, 39.101f)
                    curveTo(8.8431f, 36.3349f, 7.2693f, 35.6078f, 7.2693f, 35.6078f)
                    curveTo(5.0914f, 34.1299f, 7.4322f, 34.1576f, 7.4322f, 34.1576f)
                    curveTo(9.8446f, 34.3275f, 11.1123f, 36.6194f, 11.1123f, 36.6194f)
                    curveTo(13.2504f, 40.2667f, 16.7278f, 39.2116f, 18.0949f, 38.5952f)
                    curveTo(18.3095f, 37.0501f, 18.9335f, 35.999f, 19.621f, 35.4023f)
                    curveTo(14.2877f, 34.8017f, 8.6841f, 32.7548f, 8.6841f, 23.6108f)
                    curveTo(8.651f, 21.2394f, 9.536f, 18.9461f, 11.156f, 17.2054f)
                    curveTo(10.9096f, 16.6047f, 10.087f, 14.1785f, 11.3905f, 10.8829f)
                    curveTo(11.3905f, 10.8829f, 13.4054f, 10.2427f, 17.9916f, 13.3289f)
                    curveTo(21.9253f, 12.2592f, 26.0757f, 12.2592f, 30.0095f, 13.3289f)
                    curveTo(34.5917f, 10.2427f, 36.6026f, 10.8829f, 36.6026f, 10.8829f)
                    curveTo(37.9101f, 14.1706f, 37.0875f, 16.5968f, 36.8411f, 17.2054f)
                    curveTo(38.4662f, 18.9464f, 39.353f, 21.2437f, 39.317f, 23.6187f)
                    curveTo(39.317f, 32.7824f, 33.7015f, 34.8017f, 28.3602f, 35.3905f)
                    curveTo(29.2186f, 36.1334f, 29.9856f, 37.5836f, 29.9856f, 39.8122f)
                    curveTo(29.9856f, 43.0051f, 29.9578f, 45.5736f, 29.9578f, 46.36f)
                    curveTo(29.9578f, 46.9962f, 30.391f, 47.7391f, 31.6071f, 47.5059f)
                    curveTo(37.0119f, 45.7113f, 41.5984f, 42.0634f, 44.5462f, 37.2147f)
                    curveTo(47.4941f, 32.3659f, 48.611f, 26.6326f, 47.6972f, 21.0401f)
                    curveTo(46.7835f, 15.4476f, 43.8986f, 10.3607f, 39.5587f, 6.6892f)
                    curveTo(35.2187f, 3.0177f, 29.7067f, 1.0011f, 24.0085f, 1.0f)
                    horizontalLineTo(24.0005f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(16.0557f, 39.9505f)
                    curveTo(16.0557f, 40.1442f, 15.8331f, 40.3101f, 15.547f, 40.3141f)
                    curveTo(15.2608f, 40.318f, 15.0264f, 40.16f, 15.0264f, 39.9663f)
                    curveTo(15.0264f, 39.7727f, 15.2489f, 39.6067f, 15.535f, 39.6028f)
                    curveTo(15.8212f, 39.5988f, 16.0557f, 39.753f, 16.0557f, 39.9505f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(17.8838f, 39.6463f)
                    curveTo(17.9196f, 39.8399f, 17.7208f, 40.0414f, 17.4347f, 40.0888f)
                    curveTo(17.1486f, 40.1363f, 16.8982f, 40.0217f, 16.8624f, 39.832f)
                    curveTo(16.8267f, 39.6423f, 17.0333f, 39.4368f, 17.3115f, 39.3855f)
                    curveTo(17.5897f, 39.3341f, 17.848f, 39.4526f, 17.8838f, 39.6463f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(14.0923f, 39.8162f)
                    curveTo(14.0327f, 40.0019f, 13.7625f, 40.0849f, 13.4922f, 40.0058f)
                    curveTo(13.222f, 39.9268f, 13.0432f, 39.7055f, 13.0948f, 39.5158f)
                    curveTo(13.1465f, 39.3262f, 13.4207f, 39.2392f, 13.6949f, 39.3262f)
                    curveTo(13.9691f, 39.4131f, 14.144f, 39.6225f, 14.0923f, 39.8162f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(12.2921f, 39.0417f)
                    curveTo(12.161f, 39.1879f, 11.8947f, 39.1484f, 11.6761f, 38.9508f)
                    curveTo(11.4575f, 38.7532f, 11.4059f, 38.4845f, 11.537f, 38.3423f)
                    curveTo(11.6682f, 38.2f, 11.9344f, 38.2395f, 12.161f, 38.4331f)
                    curveTo(12.3875f, 38.6268f, 12.4312f, 38.8994f, 12.2921f, 39.0417f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(11.0085f, 37.7139f)
                    curveTo(10.8614f, 37.8167f, 10.6111f, 37.7139f, 10.472f, 37.5085f)
                    curveTo(10.4335f, 37.4716f, 10.4029f, 37.4274f, 10.382f, 37.3785f)
                    curveTo(10.3611f, 37.3296f, 10.3503f, 37.2771f, 10.3503f, 37.2239f)
                    curveTo(10.3503f, 37.1708f, 10.3611f, 37.1183f, 10.382f, 37.0694f)
                    curveTo(10.4029f, 37.0205f, 10.4335f, 36.9763f, 10.472f, 36.9394f)
                    curveTo(10.619f, 36.8406f, 10.8694f, 36.9394f, 11.0085f, 37.141f)
                    curveTo(11.1476f, 37.3425f, 11.1516f, 37.6112f, 11.0085f, 37.7139f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(10.0626f, 36.3428f)
                    curveTo(9.9803f, 36.384f, 9.8861f, 36.3955f, 9.7962f, 36.3753f)
                    curveTo(9.7063f, 36.3551f, 9.6263f, 36.3045f, 9.5698f, 36.2321f)
                    curveTo(9.4148f, 36.0662f, 9.383f, 35.837f, 9.5022f, 35.7342f)
                    curveTo(9.6214f, 35.6315f, 9.8361f, 35.6789f, 9.991f, 35.8449f)
                    curveTo(10.146f, 36.0108f, 10.1818f, 36.24f, 10.0626f, 36.3428f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(9.0889f, 35.264f)
                    curveTo(9.0372f, 35.3826f, 8.8464f, 35.4181f, 8.6915f, 35.3351f)
                    curveTo(8.5365f, 35.2522f, 8.4212f, 35.098f, 8.4769f, 34.9755f)
                    curveTo(8.5325f, 34.853f, 8.7193f, 34.8214f, 8.8743f, 34.9044f)
                    curveTo(9.0293f, 34.9874f, 9.1485f, 35.1455f, 9.0889f, 35.264f)
                    close()
                }
            }
        }
            .build()
        return githubIcon!!
    }

private var githubIcon: ImageVector? = null
