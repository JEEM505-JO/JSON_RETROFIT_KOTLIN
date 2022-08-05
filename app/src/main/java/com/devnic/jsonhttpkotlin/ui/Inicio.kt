package com.devnic.jsonhttpkotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.devnic.jsonhttpkotlin.R
import com.devnic.jsonhttpkotlin.databinding.FragmentInicioBinding
import com.devnic.jsonhttpkotlin.util.QrScan
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class Inicio : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private lateinit var viewModel: InicioViewModel
    private var qrScan : QrScan = QrScan()

    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->

        qrScan.scan(result)
//        if (result.contents == null) {
//            Toast.makeText(requireActivity(), "Cancelled", Toast.LENGTH_LONG).show()
//        } else {
//            Toast.makeText(requireActivity(), "Scanned: " + result.contents, Toast.LENGTH_LONG)
//                .show()
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inicio, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[InicioViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idNavegar.setOnClickListener {
            it.findNavController().navigate(InicioDirections.actionInicioToPetitionFragment())
        }
        binding.idQRlector.setOnClickListener {
//            initScanner()
            barcodeLauncher.launch(qrScan.scanoption())
            qrScan.scanResult.observeForever {
                binding.idresultqr.text = it
            }
        }
    }

    private fun initScanner() {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Scan a barcode")
        barcodeLauncher.launch(options)
//        options.setCameraId(0) // Use a specific camera of the device
//        options.setBeepEnabled(false)
//        options.setBarcodeImageEnabled(true)
    }


}