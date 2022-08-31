/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin


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
