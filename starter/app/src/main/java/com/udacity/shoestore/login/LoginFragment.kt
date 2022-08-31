package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.loginViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Navigates back to title when button is pressed
        viewModel.eventLogin.observe(viewLifecycleOwner, Observer { login ->
            if (login) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                viewModel.onLoginComplete()
            }
        })

        viewModel.eventCreateAccount.observe(viewLifecycleOwner, Observer { login ->
            if (login) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                viewModel.onCreateAccountComplete()
            }
        })
        return binding.root
    }
}