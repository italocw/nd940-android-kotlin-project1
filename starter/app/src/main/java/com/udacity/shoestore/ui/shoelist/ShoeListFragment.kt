package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         setHasOptionsMenu(true)
         return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
           // R.id.logout -> //shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}