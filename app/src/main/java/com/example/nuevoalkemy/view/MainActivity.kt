package com.example.nuevoalkemy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nuevoalkemy.data.Constantes
import com.example.nuevoalkemy.data.Pelicula
import com.example.nuevoalkemy.data.ResultPelicula
import com.example.nuevoalkemy.databinding.ActivityMainBinding
import com.example.nuevoalkemy.modelo.ApiService
import com.example.nuevoalkemy.modelo.UsarRetrofit
import com.example.nuevoalkemy.view.adaptadores.PeliculaAdapter
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService:ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListadoPeli.layoutManager = LinearLayoutManager(this)
        val usarRetrofit = UsarRetrofit()
        apiService = usarRetrofit.retrofit.create<ApiService>(ApiService::class.java)
        obtenerPeliculas()

}
    private fun obtenerPeliculas() {
        GlobalScope.launch(Dispatchers.IO){

        apiService.traerPeliculas().enqueue(object:Callback<ResultPelicula>{
            override fun onResponse(
                call: Call<ResultPelicula>,
                response: Response<ResultPelicula>
            ) {
                val listaPeliculas=response.body()!!.results
                binding.rvListadoPeli.adapter = PeliculaAdapter(listaPeliculas)
            }

            override fun onFailure(call: Call<ResultPelicula>, t: Throwable) {

            }


        }
        )}
    }
}
