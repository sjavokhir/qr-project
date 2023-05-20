package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun String.removeSeparator(): String {
    return replace("\n", "")
}

fun String.removeSpace(): String {
    return replace(" ", "")
}