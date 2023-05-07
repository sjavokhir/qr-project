package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia

sealed interface SocialMediaEvent {
    data class UsernameChanged(val text: String) : SocialMediaEvent
}
