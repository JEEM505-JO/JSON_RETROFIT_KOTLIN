package com.devnic.jsonhttpkotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devnic.jsonhttpkotlin.R
import com.devnic.jsonhttpkotlin.api.Helper
import com.devnic.jsonhttpkotlin.databinding.FragmentPetitionBinding
import com.devnic.jsonhttpkotlin.repository.Repository

class PetitionFragment : Fragment() {

    private lateinit var viewModel: PetitionViewModel
    private lateinit var binding: FragmentPetitionBinding
    private lateinit var factory: PetitionFactory
    private var helper = Helper.getInstance()
    private val repository by lazy {
        helper?.let { Repository(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_petition, container, false)
        factory = repository?.let { PetitionFactory(it) }!!
        viewModel = ViewModelProvider(this, factory)[PetitionViewModel::class.java]
        binding.lifecycleOwner = this
        binding.getvalue = viewModel
        return binding.root
    }


}