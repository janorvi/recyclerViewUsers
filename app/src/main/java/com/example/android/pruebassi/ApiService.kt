package com.example.android.pruebassi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getAllUsers() : Call<ArrayList<User>>
}