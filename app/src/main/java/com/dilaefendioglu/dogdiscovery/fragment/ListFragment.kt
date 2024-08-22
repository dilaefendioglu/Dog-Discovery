package com.dilaefendioglu.dogdiscovery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dilaefendioglu.dogdiscovery.MainViewModel
import com.dilaefendioglu.dogdiscovery.adapter.DogAdapter
import com.dilaefendioglu.dogdiscovery.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DogAdapter(emptyList()) { dog ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(dog)
            findNavController().navigate(action)
        }

        binding.recyclerViewDogs.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDogs.adapter = adapter

        viewModel.breeds.observe(viewLifecycleOwner) { breeds ->
            adapter.updateData(breeds)
        }

        viewModel.getBreeds()
    }
}