package com.udacity.shoestore.shoe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R


import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.main.MainViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var mainViewModel:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        viewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        mainViewModel = requireActivity().viewModels<MainViewModel>().value

        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventCancel.observe(viewLifecycleOwner) { cancel ->
            if (cancel) {
                findNavController().navigateUp()
                viewModel.onCancelComplete()
            }
        }

        viewModel.eventSave.observe(viewLifecycleOwner) { save ->
            if (save) {

                val shoe = Shoe(binding.nameText.text.toString(),binding.sizeText.text.toString().toDouble(),binding.companyText.text.toString(),binding.descriptionText.text.toString())
                mainViewModel.onAddNewShoe(shoe)

                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.onSaveComplete()
            }
        }
        return binding.root
    }
}