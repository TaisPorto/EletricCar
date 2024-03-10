package com.example.eletriccar.ui.adapter

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eletriccar.R
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class CalcularAutonomiaActivity:AppCompatActivity() {

    private lateinit var kmPercorrido: EditText
    private lateinit var resultado: TextView
    private lateinit var preco: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnClose : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)
        setupViews()
        setuplistner()


    }

    private fun setupViews() {
        preco = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_km_percorrido)
        resultado = findViewById(R.id.tv_resultado)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnClose = findViewById(R.id.iv_close)

    }

    // botão calcular
    private fun setuplistner() {
        btnCalcular.setOnClickListener {
            calcular()

        }
        // botão fechar
        btnClose.setOnClickListener{
            finish()
        }
    }
    private fun calcular() {
        val km = kmPercorrido.text.toString().toFloat()
        val preco = preco.text.toString().toFloat()
        val result = preco / km

        resultado.text = result.toString()

    }



}