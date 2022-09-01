package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password


    private val _eventCreateAccount = MutableLiveData<Boolean>()
    val eventCreateAccount: LiveData<Boolean>
        get() = _eventCreateAccount

    fun onLogin() {
            _eventLogin.value = true
    }

    fun onCreateAccount() {
        _eventCreateAccount.value = true
    }

    fun onLoginComplete() {
        _eventLogin.value = false
    }

    fun onCreateAccountComplete() {
        _eventCreateAccount.value = false
    }
}
