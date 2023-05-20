package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.replaceSeparator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class ContactScreenModel : BaseScreenModel<ContactState, ContactEvent>(ContactState()) {

    override fun onEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.FirstNameChanged -> onValueChanged(firstname = event.value)
            is ContactEvent.LastNameChanged -> onValueChanged(lastname = event.value)
            is ContactEvent.PhoneChanged -> onValueChanged(phone = event.value)
            is ContactEvent.EmailChanged -> onValueChanged(email = event.value)
            is ContactEvent.WebsiteChanged -> onValueChanged(website = event.value)
            is ContactEvent.AddressChanged -> onValueChanged(address = event.value)
        }
    }

    private fun onValueChanged(
        firstname: String? = null,
        lastname: String? = null,
        phone: String? = null,
        email: String? = null,
        website: String? = null,
        address: String? = null
    ) {
        stateData.update {
            val mFirstname = (firstname ?: it.firstname).replaceSeparator()
            val mLastname = (lastname ?: it.lastname).replaceSeparator()
            val mPhone = (phone ?: it.phone).replaceSeparator()
            val mEmail = (email ?: it.email).replaceSeparator()
            val mWebsite = (website ?: it.website).replaceSeparator()
            val mAddress = address ?: it.address

            it.copy(
                firstname = mFirstname,
                lastname = mLastname,
                phone = mPhone,
                email = mEmail,
                website = mWebsite,
                address = mAddress,
                isEnabled = (mFirstname.isNotEmpty() || mLastname.isNotEmpty()) &&
                        mPhone.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        val qrContent = buildString {
            append("BEGIN:VCARD\n")
            append("VERSION:3.0\n")

            // Name
            append("N:")
                .append(state.value.lastname).append(";")
                .append(state.value.firstname).append(";;;\n")
            append("FN:")
                .append(state.value.firstname).append(" ")
                .append(state.value.lastname).append("\n")

            // Phone
            append("TEL;TYPE=WORK,VOICE:").append(state.value.phone).append("\n")

            // Email
            append("EMAIL;TYPE=PREF,INTERNET:").append(state.value.email).append("\n")

            // Website
            append("URL:").append(state.value.website).append("\n")

            // Address
            append("ADR;TYPE=WORK:").append(state.value.address).append(";")

            append("END:VCARD")
        }
        
        return QrGenerateContent(
            qrContent = qrContent,
            formattedContent = ""
        )
    }
}