package com.udacity.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater, R.layout.fragment_welcome, container, false)

        viewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]

        binding.welcomeViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventSeeInstructions.observe(viewLifecycleOwner) { seeInstructions ->
            if (seeInstructions) {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
                viewModel.onSeeInstructionsComplete()
            }
        }

        return binding.root
    }
}