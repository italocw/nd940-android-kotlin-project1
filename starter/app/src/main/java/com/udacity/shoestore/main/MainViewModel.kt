package com.udacity.shoestore.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


    init {
        _shoeList.value = mutableListOf()
    }

    fun onAddNewShoe(shoe: Shoe) {
        _shoeList.value!!.add(shoe)
    }

}
