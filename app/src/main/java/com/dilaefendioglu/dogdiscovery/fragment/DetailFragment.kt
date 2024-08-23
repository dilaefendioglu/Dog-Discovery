package com.dilaefendioglu.dogdiscovery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.dilaefendioglu.dogdiscovery.R
import com.dilaefendioglu.dogdiscovery.databinding.FragmentDetailBinding
import com.dilaefendioglu.dogdiscovery.utils.setImageUrl

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dog = args.breed

        if (dog != null) {
            binding.txtBreedName.text = dog.name
            binding.txtBreedGroup.text =
                StringBuilder().append(getString(R.string.breed_group)).append(dog.breedgroup)
            binding.txtBreedSize.text =
                StringBuilder().append(getString(R.string.size)).append(dog.size)
            binding.txtBreedLife.text =
                StringBuilder().append(getString(R.string.life_span)).append(dog.lifespan)
            binding.txtBreedOrigin.text =
                StringBuilder().append(getString(R.string.origin)).append(dog.origin)
            binding.txtBreedTemperament.text =
                StringBuilder().append(getString(R.string.temperament)).append(dog.temperament)
            binding.txtBreedColors.text =
                StringBuilder().append(getString(R.string.colors)).append(dog.colors)
            binding.txtBreedDescription.text =
                StringBuilder().append(getString(R.string.description)).append(dog.description)
            binding.imgBreed.setImageUrl(dog.images)
        }
    }
}