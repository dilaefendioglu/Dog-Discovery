package com.dilaefendioglu.dogdiscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dilaefendioglu.dogdiscovery.service.DogApiService

class MainViewModelFactory(
    private val breedsService: DogApiService
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(breedsService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
