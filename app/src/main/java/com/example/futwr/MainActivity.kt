package com.example.futwr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvNoticias: RecyclerView
    private lateinit var noticiaAdapter: NoticiaAdapter
    private lateinit var listaNoticias: MutableList<Noticia>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNoticias = findViewById(R.id.rvNoticias)
        rvNoticias.layoutManager = LinearLayoutManager(this)

        listaNoticias = mutableListOf(
            Noticia(
                "AEK Atenas 2 - 3 Real Madrid",
                "El conjunto Madridista remonta al AEK de Atenas en Champions",
                "Comentarios (3)",
                R.drawable.madrid_atenas
            ),
            Noticia(
                "FC Barcelona 2 - 1 Real Madrid",
                "El conjunto Merengue consigue arrebatarle los tres puntos al Barcelona en el Camp Nou",
                "Comentarios (5)",
                R.drawable.clasico
            ),
            Noticia(
                "Harry Kane gana el Balón de Oro",
                "Harry Kane se lleva el Balón de Oro después de una gran temporada con el Bayern München e Inglaterra",
                "Comentarios (8)",
                R.drawable.kane
            )
        )

        noticiaAdapter = NoticiaAdapter(listaNoticias) { noticia ->
            val intent = Intent(this, ComentariosActivity::class.java)
            startActivity(intent)
        }
        rvNoticias.adapter = noticiaAdapter

        val btnBuscar = findViewById<ImageButton>(R.id.btnBuscar)
        val etBuscar = findViewById<EditText>(R.id.etBuscar)
        val tvLogo = findViewById<TextView>(R.id.tvLogo)

        btnBuscar.setOnClickListener {
            if (etBuscar.visibility == View.GONE) {
                etBuscar.visibility = View.VISIBLE
                tvLogo.visibility = View.GONE
                etBuscar.requestFocus()
            } else {
                etBuscar.visibility = View.GONE
                tvLogo.visibility = View.VISIBLE
                etBuscar.setText("")
            }
        }

        val btnPreferencias = findViewById<com.google.android.material.button.MaterialButton>(R.id.btnPreferencias)
        btnPreferencias.setOnClickListener {
            val intent = Intent(this, PreferenciasActivity::class.java)
            startActivity(intent)
        }

        val btnAyuda = findViewById<Button>(R.id.btnAyuda)
        btnAyuda?.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<ImageButton>(R.id.btnLogin)
        btnLogin?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val btnFiltros = findViewById<ImageButton>(R.id.btnFiltros)
        btnFiltros?.setOnClickListener {
            val intent = Intent(this, FiltrosActivity::class.java)
            startActivity(intent)
        }
    }
}