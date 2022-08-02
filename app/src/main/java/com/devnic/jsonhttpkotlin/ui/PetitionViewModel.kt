package com.devnic.jsonhttpkotlin.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devnic.jsonhttpkotlin.model.HeadUser
import com.devnic.jsonhttpkotlin.model.User
import com.devnic.jsonhttpkotlin.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetitionViewModel(private val repository: Repository) : ViewModel() {
    val userlist = MutableLiveData<List<User>>()
    val errorsms = MutableLiveData<String>()
    var id: String = "1";
    var email: String = "espinoza@gmail.com"
    var first_name: String = "joaquin"
    var last_name: String = "stevn"
    var avatar: String =
        "https://image.shutterstock.com/image-illustration/img-file-document-icon-trendy-260nw-1407027353.jpg"

    fun getUser() {
        val response = repository.getalldata()
        response.enqueue(object : Callback<HeadUser> {
            override fun onResponse(call: Call<HeadUser>, response: Response<HeadUser>) {
                response.body()?.let {
                    it.data.forEach { user ->
                        println(user.first_name)
                    }
                }
            }

            override fun onFailure(call: Call<HeadUser>, t: Throwable) {
                println(t.message)
            }
        })
    }

    fun seddata() {
        val response = repository.seduser(User(id, email, first_name, last_name, avatar))

        response.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                println(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println(t.message)
            }

        })
    }

}

class PetitionFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PetitionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PetitionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow viewmodel Inicio class")
    }
}