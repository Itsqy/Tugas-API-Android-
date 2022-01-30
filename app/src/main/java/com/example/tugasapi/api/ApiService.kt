package com.example.tugasapi.api


import com.example.tugasapi.model.ResponseRecipe
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("recipes")
    fun getRecipes(): Call<ResponseRecipe>
}