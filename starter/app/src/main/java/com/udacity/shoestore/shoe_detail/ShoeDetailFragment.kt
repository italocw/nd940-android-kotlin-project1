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
                requireActivity().onBackPressed()

                viewModel.onCancelComplete()
            }
        }

        viewModel.eventSave.observe(viewLifecycleOwner) { save ->
            if (save) {
                val name = binding.nameText.text.toString()
                val size = binding.sizeText.text.toString().toDouble()
                val description = binding.descriptionText.text.toString()
                val company = binding.companyText.text.toString()

                val shoe = Shoe(name, size, company, description, listOf())

               mainViewModel.onAddNewShoe(shoe)

                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.onSaveComplete()
            }
        }
        return binding.root
    }
}