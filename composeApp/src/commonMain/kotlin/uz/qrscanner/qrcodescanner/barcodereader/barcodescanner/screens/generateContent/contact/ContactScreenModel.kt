package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.removeSeparator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class ContactScreenModel : BaseScreenModel<ContactState, ContactEvent>(ContactState()) {

    override fun onEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.FirstNameChanged -> onValueChanged(firstName = event.value)
            is ContactEvent.LastNameChanged -> onValueChanged(lastName = event.value)
            is ContactEvent.PhoneChanged -> onValueChanged(phone = event.value)
            is ContactEvent.EmailChanged -> onValueChanged(email = event.value)
            is ContactEvent.WebsiteChanged -> onValueChanged(website = event.value)
            is ContactEvent.AddressChanged -> onValueChanged(address = event.value)
        }
    }

    private fun onValueChanged(
        firstName: String? = null,
        lastName: String? = null,
        phone: String? = null,
        email: String? = null,
        website: String? = null,
        address: String? = null
    ) {
        stateData.update {
            val mFirstName = (firstName ?: it.firstName).removeSeparator()
            val mLastName = (lastName ?: it.lastName).removeSeparator()
            val mPhone = (phone ?: it.phone).removeSeparator()
            val mEmail = (email ?: it.email).removeSeparator()
            val mWebsite = (website ?: it.website).removeSeparator()
            val mAddress = address ?: it.address

            it.copy(
                firstName = mFirstName,
                lastName = mLastName,
                phone = mPhone,
                email = mEmail,
                website = mWebsite,
                address = mAddress,
                isEnabled = (mFirstName.isNotEmpty() || mLastName.isNotEmpty()) &&
                        mPhone.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = buildQrContent(),
            formattedContent = buildFormattedContent()
        )
    }

    private fun buildQrContent(): String {
        return buildString {
            append("BEGIN:VCARD\n")
            append("VERSION:3.0\n")

            // Name
            append("N:")
                .append(currentState.lastName).append(";")
                .append(currentState.firstName).append(";;;\n")
            append("FN:")
                .append(currentState.firstName).append(" ")
                .append(currentState.lastName).append("\n")

            // Phone
            append("TEL;TYPE=WORK,VOICE:").append(currentState.phone).append("\n")

            // Email
            append("EMAIL;TYPE=PREF,INTERNET:").append(currentState.email).append("\n")

            // Website
            append("URL:").append(currentState.website).append("\n")

            // Address
            append("ADR;TYPE=WORK:").append(currentState.address).append(";")

            append("END:VCARD")
        }
    }

    private fun buildFormattedContent(): String {
        return buildString {
            append("First Name: ${currentState.firstName}\n")
            append("Last Name: ${currentState.lastName}\n")
            append("Phone: ${currentState.phone}\n")
            append("Email: ${currentState.email}\n")
            append("Website: ${currentState.website}\n")
            append("Address: ${currentState.address}\n")
        }
    }
}