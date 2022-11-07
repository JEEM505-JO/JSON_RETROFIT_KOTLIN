package com.devnic.jsonhttpkotlin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Helper {
    val baseurl = "https://reqres.in/api/"
    var service : Service?= null

    fun getInstance() : Service? {
        if(service == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            service = retrofit.create(Service::class.java)
        }
        return service
    }
}