package com.dilaefendioglu.dogdiscovery.service

import com.dilaefendioglu.dogdiscovery.data.DogImageResponse
import com.dilaefendioglu.dogdiscovery.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogImageService {
    @GET("breed/{breed}/images/random")
    suspend fun getImage(@Path(Constants.BREED) breed: String): Response<DogImageResponse>
}