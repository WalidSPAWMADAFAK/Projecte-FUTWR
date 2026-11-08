package com.example.futwr

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        if (btnVolver != null) {
            btnVolver.setOnClickListener {
                finish()
            }
        }
    }
}
