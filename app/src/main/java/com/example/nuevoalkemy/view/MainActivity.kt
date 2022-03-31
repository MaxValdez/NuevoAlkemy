package com.example.nuevoalkemy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nuevoalkemy.data.Constantes
import com.example.nuevoalkemy.data.Pelicula
import com.example.nuevoalkemy.databinding.ActivityMainBinding
import com.example.nuevoalkemy.modelo.ApiService
import com.example.nuevoalkemy.modelo.UsarRetrofit
import retrofit2.Call
import retrofit2.Response
import retrofit2.create


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador:PeliculaAdapter
    private val peliImagen = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclreView()


        val llamada:Response<List<Pelicula>> = UsarRetrofit().usarRetrofit().create(ApiService::class.java).traerPeliculas(Constantes.API_KEY)
        val peli = llamada.body()
        if (llamada.isSuccessful){
            val imagenes = peli?.images
            peliImagen.clear()
            peliImagen.addAll(imagenes)
        }else{
            Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_LONG).show()
        }
    }
    private fun recyclreView(){
        adaptador = PeliculaAdapter(peliImagen)
        binding.rvListadoPeli.layoutManager = LinearLayoutManager(this)
        binding.rvListadoPeli.adapter = adaptador
    }
}