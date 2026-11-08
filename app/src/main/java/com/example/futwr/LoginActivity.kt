package com.example.futwr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverLogin)
        btnVolver?.setOnClickListener {
            finish()
        }

        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        btnIniciarSesion?.setOnClickListener {
            finish()
        }

        val tvRegistrarse = findViewById<TextView>(R.id.tvRegistrarse)
        tvRegistrarse?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}