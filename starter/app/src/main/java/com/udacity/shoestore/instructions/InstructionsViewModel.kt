package com.udacity.shoestore.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private val _eventSeeShoeList = MutableLiveData<Boolean>()
    val eventSeeShoeList: LiveData<Boolean>
        get() = _eventSeeShoeList


    fun onSeeShoeList() {
        _eventSeeShoeList.value = true
    }

    fun onSeeShoeListComplete() {
        _eventSeeShoeList.value = false
    }

}
