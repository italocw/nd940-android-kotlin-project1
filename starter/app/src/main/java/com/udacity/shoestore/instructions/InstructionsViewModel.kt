package com.udacity.shoestore.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private val _eventSeeStoreList = MutableLiveData<Boolean>()
    val eventSeeStoreList: LiveData<Boolean>
        get() = _eventSeeStoreList


    fun onSeeStoreList() {
        _eventSeeStoreList.value = true
    }

    fun onSeeStoreListComplete() {
        _eventSeeStoreList.value = false
    }

}
