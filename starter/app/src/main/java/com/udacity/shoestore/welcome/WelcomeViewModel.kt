package com.udacity.shoestore.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _eventSeeInstructions = MutableLiveData<Boolean>()
    val eventSeeInstructions: LiveData<Boolean>
        get() = _eventSeeInstructions


    fun onSeeInstructions() {
        _eventSeeInstructions.value = true
    }

    fun onSeeInstructionsComplete() {
        _eventSeeInstructions.value = false
    }

}
