package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun Any?.log() {
    println("LOG_TAG: ${this?.toString()}")
}

fun tryCatch(onTryAction: () -> Unit) {
    try {
        onTryAction()
    } catch (_: Throwable) {
    }
}