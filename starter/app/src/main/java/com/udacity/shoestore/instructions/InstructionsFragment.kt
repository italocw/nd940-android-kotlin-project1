package com.udacity.shoestore.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater, R.layout.fragment_instructions, container, false
        )

        viewModel = ViewModelProvider(this)[InstructionsViewModel::class.java]

        binding.instructionsViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventSeeStoreList.observe(viewLifecycleOwner) { seeInstructions ->
            if (seeInstructions) {
                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
                viewModel.onSeeStoreListComplete()
            }
        }

        return binding.root
    }
}