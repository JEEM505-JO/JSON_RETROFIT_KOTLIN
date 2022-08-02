package com.devnic.jsonhttpkotlin.api

import com.devnic.jsonhttpkotlin.model.HeadUser
import com.devnic.jsonhttpkotlin.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {
    @GET("users")
    fun getAllData() : Call<HeadUser>

    @POST("users")
    fun sedUser(@Body user: User) : Call<User>

}