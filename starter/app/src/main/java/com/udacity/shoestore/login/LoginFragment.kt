package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.User
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.eventLogin.observe(viewLifecycleOwner) { login ->
            if (login) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                viewModel.onLoginComplete()
                User.isLoggedIn = true
            }
        }

        viewModel.eventCreateAccount.observe(viewLifecycleOwner) { login ->
            if (login) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                viewModel.onCreateAccountComplete()
                User.isLoggedIn = true
            }
        }
        if (User.isLoggedIn) {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
        }

        return binding.root
    }
}