package com.devnic.jsonhttpkotlin.repository

import com.devnic.jsonhttpkotlin.api.Service
import com.devnic.jsonhttpkotlin.model.User

class Repository(private val service: Service) {
    fun getalldata() = service.getAllData()

    fun seduser(user: User) =
        service.sedUser(user)

}