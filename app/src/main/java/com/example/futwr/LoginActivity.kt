package com.example.futwr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverLogin)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        val tvRegistrarse = findViewById<TextView>(R.id.tvRegistrarse)

        btnVolver?.setOnClickListener {
            finish()
        }

        tvRegistrarse?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginViewModel.errorMessage.observe(this) { error ->
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        }

        loginViewModel.loginResult.observe(this) { esValido ->
            if (esValido) {
                Toast.makeText(this, "Inici de sessió correcte", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnIniciarSesion?.setOnClickListener {
            val correo = etCorreo?.text?.toString()?.trim() ?: ""
            val contrasena = etContrasena?.text?.toString()?.trim() ?: ""
            loginViewModel.validarLogin(correo, contrasena)
        }
    }
}