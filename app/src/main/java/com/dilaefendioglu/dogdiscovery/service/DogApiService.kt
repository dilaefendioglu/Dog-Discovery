package com.dilaefendioglu.dogdiscovery.service

import com.dilaefendioglu.dogdiscovery.data.DogFreeResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {
    @GET("dogs")
    suspend fun getBreeds(): Response<List<DogFreeResponse>>
}



