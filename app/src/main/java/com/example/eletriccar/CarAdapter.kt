package com.example.eletriccar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccar.dominio.Carro

@Suppress("UNUSED_EXPRESSION")
class CarAdapter(private val carros: List<Carro>) :
    RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    var carIteLister: (Carro) -> Unit = {}



    // Cria uma nova view

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carro_item, parent, false)
        return ViewHolder(view)
    }

    // Quantidade de itens da lista

    override fun getItemCount(): Int = carros.size

    // Pega o conteúdo da view e troca pela informação de item de uma lista

    @SuppressLint("NotifyDataSetChanged")
    fun updateCarros(newCarrosList: List<Carro>) {
        newCarrosList
        notifyDataSetChanged()
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.preco.text = carros[position].preco
            holder.bateria.text = carros[position].bateria
            holder.recaga.text = carros[position].bateria
            holder.potencia.text = carros[position].bateria
            holder.favorito.setOnClickListener {
                val carro = (carros [position])
                carIteLister (carro)
                setupFavorite(carro, holder)
            }
    }

    private fun setupFavorite(
        carro: Carro,
        holder: ViewHolder,
    ) {
        carro.isFavorite = !carro.isFavorite

        if (carro.isFavorite)
            holder.favorito.setImageResource(R.drawable.ic_star_selected)
        else
            holder.favorito.setImageResource(R.drawable.ic_star)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val preco: TextView
        val bateria: TextView
        val potencia: TextView
        val recaga: TextView
        val favorito : ImageView

        init {
            view.apply {
                preco = findViewById(R.id.tv_preco_valor)
                bateria =findViewById(R.id.tv_bateria)
                potencia = findViewById(R.id.tv_potencia)
                recaga = findViewById(R.id.tv_recarga)
                favorito = findViewById(R.id.iv_favorite)
            }

        }
    }
}
