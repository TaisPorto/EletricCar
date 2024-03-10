@file:Suppress("DEPRECATION")

package com.example.eletriccar.ui.adapter

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccar.CarAdapter
import com.example.eletriccar.R
import com.example.eletriccar.data.CarsApi
import com.example.eletriccar.data.local.CarRepository
import com.example.eletriccar.data.local.CarrosContract
import com.example.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_BATERIA
import com.example.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_POTENCIA
import com.example.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_PRECO
import com.example.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_RECARGA
import com.example.eletriccar.data.local.CarrosContract.CarEntry.COLUMN_NAME_URL_PHOTO
import com.example.eletriccar.data.local.CarrosContract.CarEntry.TABLE_NAME
import com.example.eletriccar.data.local.CarsDbHelper
import com.example.eletriccar.dominio.Carro
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {

    private lateinit var fabCalcular: FloatingActionButton
    private lateinit var recyclerViewCarros: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var noIntentImage: ImageView
    private lateinit var nointernetText: TextView
    private lateinit var carsAPi: CarsApi

    var carrosArray: ArrayList<Carro> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRetrofit()
        setupViews(view)
        setupListeners()

    }

    override fun onResume() {
        super.onResume()
        if (checkForInternet(context)) {
           // callService() -> esse eh a outra forma de chamar serviço
            getAllCars()
        } else {
            emptyState()

        }

    }

    fun setupRetrofit() {
        val builder = Retrofit.Builder()
            .baseUrl("https://igorbag.github.io/cars-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        carsAPi = builder.create(CarsApi::class.java)

    }

    fun getAllCars() {
        carsAPi.getAllCars().enqueue(object : Callback<List<Carro>> {

            override fun onResponse(call: Call<List<Carro>>, response: Response<List<Carro>>) {
                if (response.isSuccessful) {
                    progress.isVisible = false
                    noIntentImage.isVisible = false
                    nointernetText.isVisible = false

                    response.body()?.let {
                        setupList(it)
                    }

                }else{
                    Toast.makeText(context, R.string.response_error, Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<List<Carro>>, t: Throwable) {
                Toast.makeText(context, R.string.response_error, Toast.LENGTH_LONG).show()
            }
        })

    }

    fun emptyState() {
        progress.isVisible = false
        recyclerViewCarros.isVisible = false
        noIntentImage.isVisible = true
        nointernetText.isVisible = true


    }

    private fun setupViews(view: View) {
        view.apply {
            fabCalcular = findViewById(R.id.fab_calcular)
            recyclerViewCarros = findViewById(R.id.rv_informacoes)
            progress = findViewById(R.id.pb_loader)
            noIntentImage = findViewById(R.id.iv_empty_state)
            nointernetText = findViewById(R.id.tv_no_wifi)


        }

    }


    private fun setupList(lista: List<Carro>) {

        val carroAdapter = CarAdapter(lista)

        recyclerViewCarros.apply {
           isVisible = true
            adapter = carroAdapter

        }
        carroAdapter.carIteLister = { carro ->

           val isSaved = CarRepository(requireContext()).saveIfNotExist (carro)

        }

    }

    private fun setupListeners() {

        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomiaActivity::class.java))

        }


    }

    private fun callService() {

        val urlBase: String = "https://igorbag.github.io/cars-api/cars.json"
        MyTask().execute(urlBase)

    }

    fun checkForInternet(context: Context?): Boolean {
        val connectManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            val network = connectManager.activeNetwork ?: return false
            val activeNetwork = connectManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                else -> false
            }
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    // Utilizar o retrofit como abstraçãi do AsyncTask :)
    inner class MyTask : AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()

            // Antes de começar a execução da AsyncTask, defina a ProgressBar como visível
            progress.visibility = View.VISIBLE
        }


        override fun doInBackground(vararg params: String?): String {
            lateinit var urlConnection: HttpURLConnection
            var response = ""


            try {
                val urlBase = URL(params[0])
                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000
                urlConnection.setRequestProperty("Accept", "application/json")

                val responseCode = urlConnection.responseCode
                println(responseCode)
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    response = urlConnection.inputStream.bufferedReader().use { it.readText() }
                } else {
                    Log.e("Erro", "Serviço indisponível no momento...")
                }
            } catch (ex: Exception) {
                Log.e("Erro", "Erro ao realizar processamento ...")
            }
            return response

        }


        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            if (result != null) {
                try {
                    val jsonArray = JSONTokener(result).nextValue() as JSONArray

                    for (i in 0 until jsonArray.length()) {
                        val id = jsonArray.getJSONObject(i).getString("id")
                        Log.d("ID ->", id)

                        val preco = jsonArray.getJSONObject(i).getString("preco")
                        Log.d("Preco ->", preco)

                        val bateria = try {
                            jsonArray.getJSONObject(i).getString("bateria")
                        } catch (e: JSONException) {
                            "Valor Padrão da Bateria"
                        }
                        Log.d("Bateria ->", bateria)

                        val potencia = jsonArray.getJSONObject(i).getString("potencia")
                        Log.d("Potencia ->", potencia)

                        val recarga = jsonArray.getJSONObject(i).getString("recarga")
                        Log.d("Recarga ->", recarga)

                        val urlPhoto = jsonArray.getJSONObject(i).getString("urlPhoto")
                        Log.d("Url ->", urlPhoto)

                        val model = Carro (
                            id = id.toInt(),
                            preco = preco,
                            bateria = bateria,
                            potencia = potencia,
                            recarga = recarga,
                            urlPhoto = urlPhoto,
                            isFavorite = false
                        )
                        carrosArray.add(model)


                    }
                    progress.isVisible = false
                    noIntentImage.isVisible = false
                    nointernetText.isVisible = false
                    //setupList()
                } catch (e: Exception) {
                    Log.e("Erro ->", e.message.toString())
                }
            } else {
                Log.e("JSON", "Resposta nula do servidor")
            }
        }
    }

}

