package com.dilaefendioglu.dogdiscovery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dilaefendioglu.dogdiscovery.adapter.DogAdapter
import com.dilaefendioglu.dogdiscovery.api.DogFreeApi
import com.dilaefendioglu.dogdiscovery.api.DogImageApi
import com.dilaefendioglu.dogdiscovery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var dogAdapter: DogAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val breedsService = DogFreeApi.api
        val imageService = DogImageApi.api

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(breedsService)
        ).get(MainViewModel::class.java)

        // RecyclerView ve Adapter yapılandırması
        dogAdapter = DogAdapter(emptyList())
        binding.recyclerViewDogs.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDogs.adapter = dogAdapter

        // Veriyi gözlemleme ve RecyclerView'i güncelleme
        mainViewModel.breeds.observe(this) { breedsList ->
            if (breedsList != null && breedsList.isNotEmpty()) {
                dogAdapter.updateData(breedsList)
                binding.txtError.isVisible = false
            } else {
                binding.txtError.text = "Error: No data available"
                binding.txtError.isVisible = true
            }
        }
        // Hata durumunu gözlemleme
        mainViewModel.hasError.observe(this) { hasError ->
            if (hasError) {
                binding.txtError.text = "Error: Could not load data"
                binding.txtError.isVisible = true
            }
        }
        mainViewModel.getBreeds()
    }
}
