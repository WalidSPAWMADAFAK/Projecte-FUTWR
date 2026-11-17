package com.example.futwr

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val _registerResult = MutableLiveData<Boolean>()
    val registerResult: LiveData<Boolean> get() = _registerResult

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun validarRegistro(usuario: String, email: String, password: String, confirmPassword: String) {
        if (usuario.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            _errorMessage.value = "Todos los campos son obligatorios."
            _registerResult.value = false
            return
        }

        if (usuario.length < 3) {
            _errorMessage.value = "El nombre de usuario debe tener al menos 3 caracteres."
            _registerResult.value = false
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _errorMessage.value = "Introduce un correo electrónico válido."
            _registerResult.value = false
            return
        }

        if (password.length < 6) {
            _errorMessage.value = "La contraseña debe tener al menos 6 caracteres."
            _registerResult.value = false
            return
        }

        if (password != confirmPassword) {
            _errorMessage.value = "Las contraseñas no coinciden."
            _registerResult.value = false
            return
        }

        _errorMessage.value = null
        _registerResult.value = true
    }
}