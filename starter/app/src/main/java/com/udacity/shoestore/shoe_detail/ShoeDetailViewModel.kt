package com.udacity.shoestore.shoe_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {

    private val _eventCancel = MutableLiveData<Boolean>()
    val eventCancel: LiveData<Boolean>
        get() = _eventCancel

     private val _eventSave = MutableLiveData<Boolean>()
    val eventSave: LiveData<Boolean>
        get() = _eventSave


    fun onCancel() {
            _eventCancel.value = true
    }

    fun onCancelComplete() {
        _eventCancel.value = false
    }

    fun onSave() {
        _eventSave.value = true
    }

    fun onSaveComplete() {
        _eventSave.value = false
    }
}
