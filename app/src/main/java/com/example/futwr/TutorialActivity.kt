package com.example.futwr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)
        if (btnSiguiente != null) {
            btnSiguiente.setOnClickListener {
                val intent = Intent(this, SolucionesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}