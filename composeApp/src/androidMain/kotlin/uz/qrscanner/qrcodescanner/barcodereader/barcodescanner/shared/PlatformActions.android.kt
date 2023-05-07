package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.shared

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.AndroidApp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.tryCatch

actual fun toast(message: String) {
    Toast.makeText(AndroidApp.INSTANCE, message, Toast.LENGTH_LONG).show()
}

actual fun openUrl(url: String) {
    tryCatch {
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(url)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        AndroidApp.INSTANCE.startActivity(intent)
    }
}

actual fun shareText(text: String) {
    tryCatch {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        val shareIntent = Intent.createChooser(intent, null).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        AndroidApp.INSTANCE.startActivity(shareIntent)
    }
}