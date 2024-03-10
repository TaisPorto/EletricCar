package com.example.eletriccar.dominio

import com.example.eletriccar.ui.adapter.FavoriteFragment

data class Carro(
      val id: Int,
      val preco: String,
      val potencia: String,
      val bateria: String,
      val recarga: String,
      val urlPhoto: String,
      var isFavorite: Boolean
)