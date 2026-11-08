package com.example.futwr

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PreferenciasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencies)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarPreferencias)

        btnVolver.setOnClickListener {
            finish()
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}