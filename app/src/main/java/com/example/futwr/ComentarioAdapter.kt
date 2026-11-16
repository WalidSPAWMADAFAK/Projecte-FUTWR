package com.example.futwr

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


data class ComentarioItem(
    var partido: String,
    var texto: String,
    var fecha: String
)

class ComentarioAdapter(
    private val listaComentarios: MutableList<ComentarioItem>
) : RecyclerView.Adapter<ComentarioAdapter.ComentarioViewHolder>() {

    class ComentarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPartido: TextView = itemView.findViewById(R.id.tvPartidoComentario)
        val tvTexto: TextView = itemView.findViewById(R.id.tvTextoComentario)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFechaComentario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comentario, parent, false)
        return ComentarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComentarioViewHolder, position: Int) {
        val comentario = listaComentarios[position]
        holder.tvPartido.text = comentario.partido
        holder.tvTexto.text = comentario.texto
        holder.tvFecha.text = comentario.fecha

        holder.itemView.setOnLongClickListener {
            val context = holder.itemView.context
            val opciones = arrayOf("Modificar comentario", "Eliminar comentario")

            AlertDialog.Builder(context)
                .setTitle("Gestión de Comentario")
                .setItems(opciones) { _, which ->
                    val posActual = holder.adapterPosition
                    if (posActual != RecyclerView.NO_POSITION) {
                        when (which) {
                            0 -> mostrarDialogoModificar(context, posActual)
                            1 -> eliminarComentario(context, posActual)
                        }
                    }
                }
                .show()
            true
        }
    }

    override fun getItemCount(): Int = listaComentarios.size

    fun agregarComentario(comentario: ComentarioItem) {
        listaComentarios.add(0, comentario)
        notifyItemInserted(0)
        Log.d("FUTWR_EVENT", "Comentario añadido: ${comentario.texto}")
    }

    private fun mostrarDialogoModificar(context: android.content.Context, position: Int) {
        val input = EditText(context)
        input.setText(listaComentarios[position].texto)

        AlertDialog.Builder(context)
            .setTitle("Modificar comentario")
            .setView(input)
            .setPositiveButton("Guardar") { _, _ ->
                val nuevoTexto = input.text.toString()
                if (nuevoTexto.isNotBlank()) {
                    listaComentarios[position].texto = nuevoTexto
                    notifyItemChanged(position)
                    Toast.makeText(context, "Comentario modificado", Toast.LENGTH_SHORT).show()
                    Log.d("FUTWR_EVENT", "Comentario modificado en posición $position")
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun eliminarComentario(context: android.content.Context, position: Int) {
        listaComentarios.removeAt(position)
        notifyItemRemoved(position)
        Toast.makeText(context, "Comentario eliminado", Toast.LENGTH_SHORT).show()
        Log.d("FUTWR_EVENT", "Comentario eliminado en posición $position")
    }
}