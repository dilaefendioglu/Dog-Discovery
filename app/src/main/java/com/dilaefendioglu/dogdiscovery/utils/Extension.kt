package com.dilaefendioglu.dogdiscovery.utils

object Extension {

    fun formatBreedName(breedName: String): String {
        return breedName.split(" ")[0].lowercase().replace(" ", "_")
    }
}
