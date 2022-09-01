package com.udacity.shoestore.shoe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R


import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)

        viewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]

        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.eventCancel.observe(viewLifecycleOwner) { cancel ->
            if (cancel) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.onCancelComplete()
            }
        }

        viewModel.eventSave.observe(viewLifecycleOwner) { save ->
            if (save) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.onSaveComplete()
            }
        }
        return binding.root
    }
}