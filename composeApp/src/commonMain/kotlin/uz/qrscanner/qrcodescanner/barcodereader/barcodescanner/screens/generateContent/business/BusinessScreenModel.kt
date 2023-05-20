package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.business

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.removeSeparator
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class BusinessScreenModel : BaseScreenModel<BusinessState, BusinessEvent>(BusinessState()) {

    override fun onEvent(event: BusinessEvent) {
        when (event) {
            is BusinessEvent.NameChanged -> onValueChanged(name = event.value)
            is BusinessEvent.IndustryChanged -> onValueChanged(industry = event.value)
            is BusinessEvent.PhoneChanged -> onValueChanged(phone = event.value)
            is BusinessEvent.EmailChanged -> onValueChanged(email = event.value)
            is BusinessEvent.WebsiteChanged -> onValueChanged(website = event.value)
            is BusinessEvent.AddressChanged -> onValueChanged(address = event.value)
        }
    }

    private fun onValueChanged(
        name: String? = null,
        industry: String? = null,
        phone: String? = null,
        email: String? = null,
        website: String? = null,
        address: String? = null
    ) {
        stateData.update {
            val mName = (name ?: it.name).removeSeparator()
            val mIndustry = (industry ?: it.industry).removeSeparator()
            val mPhone = (phone ?: it.phone).removeSeparator()
            val mEmail = (email ?: it.email).removeSeparator()
            val mWebsite = (website ?: it.website).removeSeparator()
            val mAddress = address ?: it.address

            it.copy(
                name = mName,
                industry = mIndustry,
                phone = mPhone,
                email = mEmail,
                website = mWebsite,
                address = mAddress,
                isEnabled = (mName.isNotEmpty() || mIndustry.isNotEmpty()) &&
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

            // Organization
            append("ORG:").append(state.value.name).append("\n")
            append("INDUSTRY:").append(state.value.industry).append("\n")

            // Phone
            append("TEL;TYPE=WORK,VOICE:").append(state.value.phone).append("\n")

            // Email
            append("EMAIL;TYPE=PREF,INTERNET:").append(state.value.email).append("\n")

            // Website
            append("URL:").append(state.value.website).append("\n")

            // Address
            append("ADR;TYPE=WORK:").append(state.value.address).append("\n")

            append("END:VCARD")
        }
    }

    private fun buildFormattedContent(): String {
        return buildString {
            append("Company Name: ${state.value.name}\n")
            append("Industry: ${state.value.industry}\n")
            append("Phone: ${state.value.phone}\n")
            append("Email: ${state.value.email}\n")
            append("Website: ${state.value.website}\n")
            append("Address: ${state.value.address}\n")
        }
    }
}