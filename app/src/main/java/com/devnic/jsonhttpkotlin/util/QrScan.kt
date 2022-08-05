package com.devnic.jsonhttpkotlin.util

import android.net.wifi.ScanResult
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class QrScan {
    val scanResult : MutableLiveData<String> = MutableLiveData()

    fun scan(result : ScanIntentResult){
        if (result.contents == null) {
            println("CANCEL")
        } else {
            println("Result ${result.contents}")
            scanResult.postValue(result.contents)
        }
    }

    fun scanoption(): ScanOptions {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Scan a barcode")
//        options.setCameraId(0) // Use a specific camera of the device
//        options.setBeepEnabled(false)
//        options.setBarcodeImageEnabled(true)
        return options
    }

}