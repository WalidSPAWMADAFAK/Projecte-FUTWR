package com.example.futwr

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverRegistro)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnVolver?.setOnClickListener {
            finish()
        }
        btnRegistrar?.setOnClickListener {
            finish()
        }
    }
}