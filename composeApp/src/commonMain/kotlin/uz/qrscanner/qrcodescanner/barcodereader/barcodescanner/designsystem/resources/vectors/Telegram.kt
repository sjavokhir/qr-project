package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TelegramIcon: ImageVector
    get() {
        if (telegramIcon != null) return telegramIcon!!

        telegramIcon = Builder(
            name = "Telegram", defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd
                ) {
                    moveTo(48.0f, 24.0f)
                    curveTo(48.0f, 37.2548f, 37.2548f, 48.0f, 24.0f, 48.0f)
                    curveTo(10.7452f, 48.0f, 0.0f, 37.2548f, 0.0f, 24.0f)
                    curveTo(0.0f, 10.7452f, 10.7452f, 0.0f, 24.0f, 0.0f)
                    curveTo(37.2548f, 0.0f, 48.0f, 10.7452f, 48.0f, 24.0f)
                    close()
                    moveTo(24.8601f, 17.7179f)
                    curveTo(22.5257f, 18.6888f, 17.8603f, 20.6984f, 10.8638f, 23.7466f)
                    curveTo(9.7277f, 24.1984f, 9.1325f, 24.6404f, 9.0783f, 25.0726f)
                    curveTo(8.9868f, 25.803f, 9.9014f, 26.0906f, 11.1469f, 26.4822f)
                    curveTo(11.3164f, 26.5355f, 11.4919f, 26.5907f, 11.6719f, 26.6492f)
                    curveTo(12.8973f, 27.0475f, 14.5457f, 27.5135f, 15.4026f, 27.5321f)
                    curveTo(16.1799f, 27.5489f, 17.0475f, 27.2284f, 18.0053f, 26.5707f)
                    curveTo(24.5423f, 22.158f, 27.9168f, 19.9276f, 28.1286f, 19.8795f)
                    curveTo(28.2781f, 19.8456f, 28.4852f, 19.803f, 28.6255f, 19.9277f)
                    curveTo(28.7659f, 20.0524f, 28.7521f, 20.2886f, 28.7372f, 20.352f)
                    curveTo(28.6466f, 20.7383f, 25.0562f, 24.0762f, 23.1982f, 25.8036f)
                    curveTo(22.619f, 26.3421f, 22.2081f, 26.724f, 22.1242f, 26.8113f)
                    curveTo(21.936f, 27.0067f, 21.7443f, 27.1915f, 21.56f, 27.3692f)
                    curveTo(20.4215f, 28.4667f, 19.5678f, 29.2896f, 21.6072f, 30.6336f)
                    curveTo(22.5873f, 31.2794f, 23.3715f, 31.8135f, 24.1539f, 32.3463f)
                    curveTo(25.0084f, 32.9282f, 25.8606f, 33.5085f, 26.9632f, 34.2313f)
                    curveTo(27.2442f, 34.4155f, 27.5125f, 34.6068f, 27.7738f, 34.7931f)
                    curveTo(28.7681f, 35.5019f, 29.6615f, 36.1388f, 30.7652f, 36.0373f)
                    curveTo(31.4065f, 35.9782f, 32.0689f, 35.3752f, 32.4053f, 33.5767f)
                    curveTo(33.2004f, 29.3263f, 34.7633f, 20.1169f, 35.1244f, 16.3219f)
                    curveTo(35.1561f, 15.9895f, 35.1163f, 15.5639f, 35.0843f, 15.3771f)
                    curveTo(35.0523f, 15.1904f, 34.9855f, 14.9242f, 34.7427f, 14.7272f)
                    curveTo(34.4552f, 14.4939f, 34.0113f, 14.4447f, 33.8127f, 14.4482f)
                    curveTo(32.91f, 14.4641f, 31.5251f, 14.9456f, 24.8601f, 17.7179f)
                    close()
                }
            }
        }
            .build()
        return telegramIcon!!
    }

private var telegramIcon: ImageVector? = null
