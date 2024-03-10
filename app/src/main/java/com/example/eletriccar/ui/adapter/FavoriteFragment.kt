package com.example.eletriccar.ui.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccar.CarAdapter
import com.example.eletriccar.R
import com.example.eletriccar.data.local.CarRepository
import com.example.eletriccar.dominio.Carro

class FavoriteFragment: Fragment() {

    private lateinit var recyclerViewCarrosFavoritos: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        setupList()

    }

    private fun getCarsOnLocalDb(): List<Carro> {
        val repository = CarRepository(requireContext())
        val carlist = repository.getAll()
        return carlist
    }

    private fun setupViews(view: View) {
        view.apply {
           recyclerViewCarrosFavoritos = findViewById(R.id.rv_informacoes_favoritos)

        }

    }

    private fun setupList() {
        val cars = getCarsOnLocalDb()

        val carroAdapter = CarAdapter(cars)

        recyclerViewCarrosFavoritos.apply {
            isVisible = true
            adapter = carroAdapter

        }
        carroAdapter.carIteLister = { carro ->

            //val isSaved = CarRepository(requireContext()).saveIfNotExist (carro)

        }

    }
}