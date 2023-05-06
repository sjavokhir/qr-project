package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateCode.socialMedia

sealed class SocialMediaEvent {
    data class UsernameChanged(val text: String) : SocialMediaEvent()
}
