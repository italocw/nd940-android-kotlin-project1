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

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _size = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _size

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description




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
