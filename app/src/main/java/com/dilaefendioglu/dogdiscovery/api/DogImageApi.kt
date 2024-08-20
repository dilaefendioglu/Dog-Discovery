// DogImageApi.kt
package com.dilaefendioglu.dogdiscovery.api

import com.dilaefendioglu.dogdiscovery.DogImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogImageApi {
    @GET("breed/{breed}/images/random")
    suspend fun getImage(@Path("breed") breed: String): Response<DogImageResponse>

    companion object {
        private const val BASE_URL = "https://dog.ceo/api/"

        val api: DogImageApi by lazy {
            retrofit.create(DogImageApi::class.java)
        }
        private val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
    }
}
