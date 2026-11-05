package com.example.futwr

import android.os.Bundle
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
                "Harry Kane se lleva el Balon de Oro despues de una gran temporada con el Bayern Munchen e Inglaterra",
                "Comentarios (8)",
                R.drawable.kane
            )
        )

        noticiaAdapter = NoticiaAdapter(listaNoticias)
        rvNoticias.adapter = noticiaAdapter
    }
}