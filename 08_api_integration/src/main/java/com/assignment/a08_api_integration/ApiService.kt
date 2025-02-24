package com.assignment.a08_api_integration

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getItems(): Call<List<ItemModel>>
}