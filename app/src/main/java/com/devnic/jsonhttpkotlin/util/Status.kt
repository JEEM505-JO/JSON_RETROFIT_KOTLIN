package com.devnic.jsonhttpkotlin.util

sealed interface Status{
    data class Success(val data: String) : Status
    data class Error(val message: String) : Status
    object NoState : Status
    object Loading : Status
}
