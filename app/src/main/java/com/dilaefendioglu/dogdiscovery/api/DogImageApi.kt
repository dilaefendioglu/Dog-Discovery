// DogImageApi.kt
package com.dilaefendioglu.dogdiscovery.api

import com.dilaefendioglu.dogdiscovery.service.DogImageService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogImageApi {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
      val api: DogImageService by lazy {
          retrofit.create(DogImageService::class.java)
      }
    }

