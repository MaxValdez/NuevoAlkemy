package com.example.nuevoalkemy.modelo

import com.example.nuevoalkemy.data.Pelicula
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun traerPeliculas(@Url url:String): Response<List<Pelicula>>
}