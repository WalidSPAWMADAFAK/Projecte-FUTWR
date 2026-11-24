package com.example.futwr

class Noticia(
    var titulo: String,
    var cuerpo: String,
    val comentarios: String,
    val imagenResId: Int,
    val categoria: String = "Partits"
)