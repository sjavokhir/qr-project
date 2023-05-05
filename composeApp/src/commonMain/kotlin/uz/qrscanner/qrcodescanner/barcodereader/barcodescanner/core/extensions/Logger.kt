package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun tryCatch(onTryAction: () -> Unit) {
    try {
        onTryAction()
    } catch (_: Throwable) {
    }
}