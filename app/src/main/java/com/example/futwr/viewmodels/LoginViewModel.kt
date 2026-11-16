package com.example.futwr

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun validarLogin(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _errorMessage.value = "Por favor, rellena todos los campos."
            _loginResult.value = false
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _errorMessage.value = "El formato del correo electrónico no es válido."
            _loginResult.value = false
            return
        }
        if (password.length < 6) {
            _errorMessage.value = "La contraseña debe tener al menos 6 caracteres."
            _loginResult.value = false
            return
        }

        _errorMessage.value = null
        _loginResult.value = true
    }
}