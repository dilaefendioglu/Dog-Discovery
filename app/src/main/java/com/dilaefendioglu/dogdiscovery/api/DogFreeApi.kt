package com.dilaefendioglu.dogdiscovery.api

import com.dilaefendioglu.dogdiscovery.service.DogApiService
import com.dilaefendioglu.dogdiscovery.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogFreeApi {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.FREE_API_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: DogApiService by lazy {
        retrofit.create(DogApiService::class.java)
    }
}
