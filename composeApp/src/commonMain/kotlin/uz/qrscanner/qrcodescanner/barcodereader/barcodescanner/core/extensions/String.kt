package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun String.replaceSeparator(): String {
    return replace("\n", "")
}

fun String.replaceSpace(): String {
    return replace(" ", "")
}