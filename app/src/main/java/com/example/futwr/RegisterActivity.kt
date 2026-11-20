package com.example.futwr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverRegistro)
        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etCorreoRegistro = findViewById<EditText>(R.id.etCorreoRegistro)
        val etContrasenaRegistro = findViewById<EditText>(R.id.etContrasenaRegistro)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnVolver?.setOnClickListener {
            finish()
        }

        registerViewModel.errorMessage.observe(this) { error ->
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        }


        registerViewModel.registerResult.observe(this) { esValido ->
            if (esValido) {
                Toast.makeText(this, "Registre completat correctament", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btnRegistrar?.setOnClickListener {
            val usuario = etUsuario?.text?.toString()?.trim() ?: ""
            val correo = etCorreoRegistro?.text?.toString()?.trim() ?: ""
            val contrasena = etContrasenaRegistro?.text?.toString()?.trim() ?: ""

            registerViewModel.validarRegistro(usuario, correo, contrasena)
        }
    }
}