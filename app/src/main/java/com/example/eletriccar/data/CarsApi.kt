package com.example.eletriccar.data

import android.telecom.Call
import com.example.eletriccar.dominio.Carro
import retrofit2.http.GET

interface CarsApi {


    @GET("cars.json")

    fun getAllCars(): retrofit2.Call<List<Carro>>

}