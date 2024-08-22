package com.dilaefendioglu.dogdiscovery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dilaefendioglu.dogdiscovery.R
import com.dilaefendioglu.dogdiscovery.data.DogFreeResponse
import com.dilaefendioglu.dogdiscovery.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bundle'dan veriyi alma
        val dog = arguments?.getSerializable("breed") as? DogFreeResponse

        if (dog != null) {
            // UI'ı güncelle
            binding.txtBreedName.text = dog.name
            binding.txtBreedGroup.text = StringBuilder().append("Breed Group: ").append(dog.breed_group)
            binding.txtBreedSize.text = StringBuilder().append("Size: ").append(dog.size)
            binding.txtBreedLife.text = StringBuilder().append("Life span: ").append(dog.lifespan)
            binding.txtBreedOrigin.text = StringBuilder().append("Origin: ").append(dog.origin)
            binding.txtBreedTemperament.text = StringBuilder().append("Temperament: ").append(dog.temperament)
            binding.txtBreedColors.text = StringBuilder().append("Color: ").append(dog.colors)
            binding.txtBreedDescription.text = StringBuilder().append("Description: ").append(dog.description)

            Picasso.get()
                .load(dog.images)
                .placeholder(R.drawable.load)
                .error(R.drawable.load)
                .into(binding.imgBreed)
        }
    }
}