package com.dilaefendioglu.dogdiscovery

data class DogFreeResponse(
    val id: Int,
    val name: String,
    val breed_group: String,
    val size: String,
    val lifespan: String,
    val origin: String,
    val temperament: String,
    val colors: List<String>,
    val description: String,
    var images: String? = null
)

