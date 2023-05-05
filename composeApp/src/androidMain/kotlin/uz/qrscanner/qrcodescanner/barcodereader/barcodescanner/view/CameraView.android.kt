package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.view

import android.annotation.SuppressLint
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.camera.detector.QrDetector
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.tryCatch
import java.util.*
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private val executor = Executors.newSingleThreadExecutor()

@OptIn(ExperimentalPermissionsApi::class)
@Composable
actual fun QrCameraView(
    modifier: Modifier,
    isFrontCamera: Boolean,
    onQrResult: () -> Unit
) {
    val cameraPermissionState = rememberMultiplePermissionsState(
        listOf(android.Manifest.permission.CAMERA)
    )
    if (cameraPermissionState.allPermissionsGranted) {
        QrCameraWithGrantedPermission(
            modifier = modifier,
            isFrontCamera = isFrontCamera,
            onQrResult = onQrResult
        )
    } else {
        LaunchedEffect(Unit) {
            cameraPermissionState.launchMultiplePermissionRequest()
        }
    }
}

@SuppressLint("MissingPermission")
@Composable
private fun QrCameraWithGrantedPermission(
    modifier: Modifier,
    isFrontCamera: Boolean,
    onQrResult: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val preview = remember {
        Preview.Builder()
            .setTargetAspectRatio(AspectRatio.RATIO_4_3)
            .build()
    }
    val previewView = remember { PreviewView(context) }
    val imageAnalysis = remember {
        ImageAnalysis.Builder()
            .setTargetAspectRatio(AspectRatio.RATIO_4_3)
            .build()
    }
    val cameraSelector = remember(isFrontCamera) {
        val lensFacing = if (isFrontCamera) {
            CameraSelector.LENS_FACING_FRONT
        } else {
            CameraSelector.LENS_FACING_BACK
        }
        CameraSelector.Builder()
            .requireLensFacing(lensFacing)
            .build()
    }
    val qrDetector = remember { QrDetector(context, onQrResult) }

    LaunchedEffect(isFrontCamera) {
        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(context)) {
            tryCatch {
                qrDetector.processImageProxy(it)
            }
        }

        val cameraProvider = suspendCoroutine<ProcessCameraProvider> { continuation ->
            ProcessCameraProvider.getInstance(context).also { cameraProvider ->
                cameraProvider.addListener({
                    continuation.resume(cameraProvider.get())
                }, executor)
            }
        }
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageAnalysis
        )
        preview.setSurfaceProvider(previewView.surfaceProvider)
    }

    Box(modifier = modifier) {
        AndroidView(
            { previewView },
            modifier = Modifier.fillMaxSize()
        )
    }
}
