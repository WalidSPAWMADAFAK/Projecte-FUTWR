package com.example.futwr

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MisComentariosActivity : AppCompatActivity() {

    private lateinit var adapter: ComentarioAdapter
    private lateinit var listaComentariosUsuario: MutableList<ComentarioItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_comentarios)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverComentarios)
        btnVolver.setOnClickListener { finish() }

        val rvMisComentarios = findViewById<RecyclerView>(R.id.rvMisComentarios)
        rvMisComentarios.layoutManager = LinearLayoutManager(this)

        listaComentariosUsuario = mutableListOf(
            ComentarioItem(
                "En: AEK Atenas 2 - 3 Real Madrid",
                "Lo de las remontadas en Champions es ADN puro. Buenos cambios",
                "Publicado hace 15 min · 14 Me gusta"
            ),
            ComentarioItem(
                "En: FC Barcelona 2 - 1 Real Madrid",
                "Los del Barça son unos matados.",
                "Publicado hace 3 horas · 29 Me gusta"
            ),
            ComentarioItem(
                "En: Harry Kane gana el Balón de Oro",
                "Merecidisimo felicidades mas de 60 goles que locura de jugador.",
                "Publicado ayer · 42 Me gusta"
            ),
            ComentarioItem(
                "En: AEK Atenas 2 - 3 Real Madrid",
                "Apretaron muchísimo. Casi nos empatan en el descuento.",
                "Publicado ayer · 8 Me gusta"
            ),
            ComentarioItem(
                "En: FC Barcelona 2 - 1 Real Madrid",
                "El arbitraje estuvo bastante correcto, dejó jugar y no cayó en pérdidas de tiempo. Así da gusto ver un Clásico.",
                "Publicado hace 2 días · 19 Me gusta"
            ),
            ComentarioItem(
                "En: Harry Kane gana el Balón de Oro",
                "Lamine no se lo merecia, ganador justo.",
                "Publicado hace 4 días · 31 Me gusta"
            ),
            ComentarioItem(
                "En: AEK Atenas 2 - 3 Real Madrid",
                "Necesitamos reforzar el lateral derecho urgente si queremos llegar vivos a semifinales sin sufrir tanto atrás.",
                "Publicado hace 1 semana · 11 Me gusta"
            )
        )

        adapter = ComentarioAdapter(listaComentariosUsuario)
        rvMisComentarios.adapter = adapter
    }
}