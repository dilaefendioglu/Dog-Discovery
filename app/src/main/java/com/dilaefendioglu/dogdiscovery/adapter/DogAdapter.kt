package com.dilaefendioglu.dogdiscovery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilaefendioglu.dogdiscovery.data.DogFreeResponse
import com.dilaefendioglu.dogdiscovery.R
import com.dilaefendioglu.dogdiscovery.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogAdapter(
    private var dogs: List<DogFreeResponse>,
    private val onItemClick: (DogFreeResponse) -> Unit
) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = dogs[position]
        holder.bind(dog)
        holder.itemView.setOnClickListener { onItemClick(dog) }
    }

    override fun getItemCount(): Int = dogs.size

    fun updateData(newDogs: List<DogFreeResponse>) {
        dogs = newDogs
        notifyDataSetChanged()
    }

    class DogViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: DogFreeResponse) {
            binding.txtBreedName.text = dog.name
            Picasso.get()
                .load(dog.images)
                .placeholder(R.drawable.load)
                .error(R.drawable.load)
                .into(binding.imgBreed)
            }
        }
    }
