package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions

fun String.isUrlValid(): Boolean {
    val urlRegex =
        """^(http://www\.|https://www\.|http://|https://)?[a-z\d]+([\-.][a-z\d]+)*\.[a-z]{2,5}(:\d{1,5})?(/.*)?$""".toRegex(
            RegexOption.IGNORE_CASE
        )
    return urlRegex.matches(this)
}

fun String.isEmailValid(): Boolean {
    val emailRegex = "^[A-Za-z](.*)(@)(.+)(\\.)(.+)"
    return emailRegex.toRegex().matches(this)
}
