package com.udacity.shoestore.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {

    private val _eventAddStore = MutableLiveData<Boolean>()
    val eventAddStore: LiveData<Boolean>
        get() = _eventAddStore


    fun onAddStore() {
        _eventAddStore.value = true
    }

    fun onAddStoreComplete() {
        _eventAddStore.value = false
    }

}
