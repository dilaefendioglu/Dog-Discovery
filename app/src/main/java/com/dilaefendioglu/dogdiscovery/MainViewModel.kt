package com.dilaefendioglu.dogdiscovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dilaefendioglu.dogdiscovery.api.DogFreeApi
import com.dilaefendioglu.dogdiscovery.api.DogImageApi
import com.dilaefendioglu.dogdiscovery.data.DogFreeResponse
import com.dilaefendioglu.dogdiscovery.utils.Extension
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val breedsService = DogFreeApi.api
    private val DogImageService = DogImageApi.api

    private val _breeds = MutableLiveData<List<DogFreeResponse>>()
    val breeds: LiveData<List<DogFreeResponse>> get() = _breeds

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _hasError = MutableLiveData<Boolean>()
    val hasError: LiveData<Boolean> get() = _hasError

    fun getBreeds() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = breedsService.getBreeds()
                if (response.isSuccessful && response.body() != null) {
                    val breedsList = response.body() ?: emptyList()
                    _breeds.value = breedsList
                    fetchImagesForBreeds(breedsList)
                    _hasError.value = false
                } else {
                    _hasError.value = true
                }
            } catch (e: Exception) {
                _hasError.value = true
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun fetchImagesForBreeds(breedsList: List<DogFreeResponse>) {
        viewModelScope.launch {
            breedsList.forEach { breed ->
                val breedName = Extension.formatBreedName(breed.name)
                try {
                    val imageResponse = DogImageService.getImage(breedName)
                    if (imageResponse.isSuccessful && imageResponse.body() != null) {
                        val imageUrl = imageResponse.body()?.message
                        breed.images = imageUrl
                    }
                } catch (e: Exception) {

                }
            }
            _breeds.value = breedsList
        }
    }
}
