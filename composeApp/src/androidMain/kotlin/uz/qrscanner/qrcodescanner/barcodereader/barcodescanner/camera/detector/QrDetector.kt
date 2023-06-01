package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.camera.detector

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.camera.core.VisionProcessorBase
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.tryCatch

class QrDetector(
    private val context: Context,
    private val onQrResult: () -> Unit
) : VisionProcessorBase<MutableList<Barcode>>(context) {

    private val scanner = BarcodeScanning.getClient(
        BarcodeScannerOptions
            .Builder()
            .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
            .enableAllPotentialBarcodes()
            .build()
    )

    override fun stop() {
        super.stop()
        scanner.close()
    }

    override fun detectInImage(image: InputImage): Task<MutableList<Barcode>> {
        return scanner.process(image)
    }

    override fun onSuccess(results: MutableList<Barcode>) {
        onBarcodeParser(results.mapNotNull {
            it.calendarEvent
            it.rawValue
        }.joinToString())
    }

    override fun onFailure(t: Throwable) {}

    private fun onBarcodeParser(code: String) {
        if (code.isNotEmpty()) {
            vibrate()
            onQrResult()
        }
    }

    private fun vibrate(milliseconds: Long = 400) {
        tryCatch {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager =
                    context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }

            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        milliseconds,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(milliseconds)
            }
        }
    }
}
