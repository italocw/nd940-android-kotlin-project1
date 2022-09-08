package com.udacity.shoestore.shoe_list

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.User
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.main.MainViewModel

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = this

        val navController = findNavController()

        activityViewModels<MainViewModel>().value.shoeList.observe(viewLifecycleOwner) { shoeList ->

            shoeList.forEach { shoe ->
                val newShoeTextView = TextView(context)
                newShoeTextView.text = "${shoe.name},\n ${shoe.description}\n"
                newShoeTextView.setTextAppearance(R.style.TextAppearance_Material3_TitleMedium)
                binding.shoeListLinearLayout.addView(newShoeTextView)
            }
        }


        viewModel.eventAddShoe.observe(viewLifecycleOwner) { addShoe ->
            if (addShoe) {
                navController.navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                viewModel.onAddShoeComplete()
            }
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()


        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.shoe_list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.logout -> {
                        User.isLoggedIn = false
                        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                    }

                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}

