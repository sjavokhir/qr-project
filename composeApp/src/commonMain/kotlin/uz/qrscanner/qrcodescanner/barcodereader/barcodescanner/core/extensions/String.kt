package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun String.replaceTrim(): String {
    return trim().replace("\n", "")
}

fun String.replaceSpace(): String {
    return replace(" ", "")
}