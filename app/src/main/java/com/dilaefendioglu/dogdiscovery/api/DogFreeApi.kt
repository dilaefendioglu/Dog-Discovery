package com.dilaefendioglu.dogdiscovery.api

import com.dilaefendioglu.dogdiscovery.service.DogApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogFreeApi {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://freetestapi.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: DogApiService by lazy {
        retrofit.create(DogApiService::class.java)
    }
}
//https://freetestapi.com/api/v1/dogs