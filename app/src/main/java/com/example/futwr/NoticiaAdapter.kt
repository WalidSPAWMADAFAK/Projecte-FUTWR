package com.example.futwr

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NoticiaAdapter(
    private val listaNoticias: MutableList<Noticia>,
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
        holder.itemView.setOnLongClickListener {
            val context = holder.itemView.context
            val opciones = arrayOf("Modificar noticia", "Eliminar noticia")

            AlertDialog.Builder(context)
                .setTitle("Gestión de Noticia")
                .setItems(opciones) { _, which ->
                    val posActual = holder.adapterPosition
                    if (posActual != RecyclerView.NO_POSITION) {
                        when (which) {
                            0 -> mostrarDialogoModificar(context, posActual)
                            1 -> eliminarNoticia(context, posActual)
                        }
                    }
                }
                .show()
            true
        }
    }

    override fun getItemCount(): Int {
        return listaNoticias.size
    }

    // Método para Añadir (Aparece arriba en la lista)
    fun agregarNoticia(noticia: Noticia) {
        listaNoticias.add(0, noticia)
        notifyItemInserted(0)
        Log.d("FUTWR_EVENT", "Noticia añadida con éxito: ${noticia.titulo}")
    }

    private fun mostrarDialogoModificar(context: android.content.Context, position: Int) {
        val input = EditText(context)
        input.setText(listaNoticias[position].titulo)

        AlertDialog.Builder(context)
            .setTitle("Modificar título")
            .setView(input)
            .setPositiveButton("Guardar") { _, _ ->
                val nuevoTitulo = input.text.toString()
                if (nuevoTitulo.isNotBlank()) {
                    listaNoticias[position].titulo = nuevoTitulo
                    notifyItemChanged(position)
                    Toast.makeText(context, "Noticia modificada correctamente", Toast.LENGTH_SHORT).show()
                    Log.d("FUTWR_EVENT", "Noticia modificada en posición $position: $nuevoTitulo")
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun eliminarNoticia(context: android.content.Context, position: Int) {
        val noticiaEliminada = listaNoticias.removeAt(position)
        notifyItemRemoved(position)
        Toast.makeText(context, "Noticia eliminada", Toast.LENGTH_SHORT).show()
        Log.d("FUTWR_EVENT", "Noticia eliminada: ${noticiaEliminada.titulo}")
    }
}