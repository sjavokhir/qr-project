package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun Int.az(): String = if (this >= 10) "" + this else "0$this"