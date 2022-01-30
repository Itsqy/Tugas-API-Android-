package com.example.tugasapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    const val baseUrl = "https://masak-apa-tomorisakura.vercel.app/api/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): ApiService {

        return getRetrofit().create(ApiService::class.java)

    }
}