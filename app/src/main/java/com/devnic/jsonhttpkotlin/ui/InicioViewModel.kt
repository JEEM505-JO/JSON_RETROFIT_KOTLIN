package com.devnic.jsonhttpkotlin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InicioViewModel : ViewModel() {

}

class InicioFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InicioViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InicioViewModel() as T
        }
        throw IllegalArgumentException("Unknow viewmodel Inicio class")
    }
}
