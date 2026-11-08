package com.example.futwr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticiaAdapter(
    private val listaNoticias: List<Noticia>,
    private val onComentarClick: (Noticia) -> Unit
) : RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder>() {

    class NoticiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTituloNoticia)
        val tvCuerpo: TextView = itemView.findViewById(R.id.tvCuerpoNoticia)
        val tvComentarios: TextView = itemView.findViewById(R.id.tvComentariosInfo)
        val imgNoticia: ImageView = itemView.findViewById(R.id.imgNoticia)
        val btnComentarItem: TextView = itemView.findViewById(R.id.btnComentar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return NoticiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val noticia = listaNoticias[position]
        holder.tvTitulo.text = noticia.titulo
        holder.tvCuerpo.text = noticia.cuerpo
        holder.tvComentarios.text = noticia.comentarios
        holder.imgNoticia.setImageResource(noticia.imagenResId)

        holder.btnComentarItem.setOnClickListener {
            onComentarClick(noticia)
        }
    }

    override fun getItemCount(): Int {
        return listaNoticias.size
    }
}