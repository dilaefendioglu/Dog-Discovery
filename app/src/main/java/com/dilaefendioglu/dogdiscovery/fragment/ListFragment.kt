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
import com.dilaefendioglu.dogdiscovery.R
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
            val bundle = Bundle().apply {
                putSerializable("breed", dog)
            }
            findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }

        binding.recyclerViewDogs.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDogs.adapter = adapter

        viewModel.breeds.observe(viewLifecycleOwner) { breeds ->
            adapter.updateData(breeds)
        }

        viewModel.getBreeds()
    }
}