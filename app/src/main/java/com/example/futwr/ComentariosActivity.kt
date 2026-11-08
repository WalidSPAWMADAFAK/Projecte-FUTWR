package com.example.futwr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ComentariosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentarios)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverComentarios)
        val etComentario = findViewById<EditText>(R.id.etComentario)
        val btnPublicar = findViewById<Button>(R.id.btnPublicarComentario)
        val btnEditar = findViewById<Button>(R.id.btnEditarComentario1)
        val btnEliminar = findViewById<Button>(R.id.btnEliminarComentario1)

        btnVolver.setOnClickListener {
            finish()
        }

        btnPublicar.setOnClickListener {
            val texto = etComentario.text.toString().trim()
            if (texto.isNotEmpty()) {
                Toast.makeText(this, "Comentario publicado", Toast.LENGTH_SHORT).show()
                etComentario.setText("")
            } else {
                Toast.makeText(this, "Escribe un comentario primero", Toast.LENGTH_SHORT).show()
            }
        }

        btnEditar?.setOnClickListener {
            Toast.makeText(this, "Editar comentario", Toast.LENGTH_SHORT).show()
        }

        btnEliminar?.setOnClickListener {
            Toast.makeText(this, "Eliminar comentario", Toast.LENGTH_SHORT).show()
        }
    }
}