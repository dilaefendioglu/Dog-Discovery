package com.dilaefendioglu.dogdiscovery.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DogFreeResponse(
    val id: Int,
    val name: String,
    @SerializedName("breed_group") val breedgroup: String,
    val size: String,
    val lifespan: String,
    val origin: String,
    val temperament: String,
    val colors: List<String>,
    val description: String,
    var images: String? = null
) : Serializable

