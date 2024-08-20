package com.dilaefendioglu.dogdiscovery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilaefendioglu.dogdiscovery.DogFreeResponse
import com.dilaefendioglu.dogdiscovery.R
import com.dilaefendioglu.dogdiscovery.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogAdapter(private var breeds: List<DogFreeResponse>) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    class DogViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(breed: DogFreeResponse) {
            binding.txtBreedName.text =  breed.name
            binding.txtBreedGroup.text = "Breed Group: " + breed.breed_group
            binding.txtBreedSize.text = "Size: " + breed.size
            binding.txtBreedLife.text = "Life span: " + breed.lifespan
            binding.txtBreedOrigin.text = "Origin: " + breed.origin
            binding.txtBreedTemperament.text = "Temperament: " + breed.temperament
            binding.txtBreedColors.text = "Color: " +  breed.colors.joinToString(", ")
            binding.txtBreedDescription.text = "Description: " +  breed.description

            Picasso.get()
                .load(breed.images)
                .placeholder(R.drawable.load) // Varsayılan resim burada ayarlanır
                .error(R.drawable.load) // Hata durumunda varsayılan resim gösterilir
                .into(binding.imgBreed)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(breeds[position])
    }

    override fun getItemCount(): Int = breeds.size

    fun updateData(newBreeds: List<DogFreeResponse>) {
        breeds = newBreeds
        notifyDataSetChanged()
    }
}

