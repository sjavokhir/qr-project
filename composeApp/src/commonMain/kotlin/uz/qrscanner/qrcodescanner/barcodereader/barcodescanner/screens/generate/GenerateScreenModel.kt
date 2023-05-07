package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel

class GenerateScreenModel : BaseScreenModel<GenerateState, GenerateEvent>() {

    override fun defaultState(): GenerateState = GenerateState()

    override fun onEvent(event: GenerateEvent) {
        when (event) {
            GenerateEvent.GetGenerate -> Unit
        }
    }
}