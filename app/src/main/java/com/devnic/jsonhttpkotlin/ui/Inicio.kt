package com.devnic.jsonhttpkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.devnic.jsonhttpkotlin.R
import com.devnic.jsonhttpkotlin.databinding.FragmentInicioBinding

class Inicio : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private lateinit var viewModel: InicioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_inicio,container,false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[InicioViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idNavegar.setOnClickListener {
            it.findNavController().navigate(InicioDirections.actionInicioToPetitionFragment())
        }
    }
}