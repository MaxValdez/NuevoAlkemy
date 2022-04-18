package com.example.nuevoalkemy.modelo

import com.example.nuevoalkemy.data.Constantes
import com.example.nuevoalkemy.data.Pelicula
import com.example.nuevoalkemy.data.ResultPelicula
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Url

interface ApiService {
    //@Headers("api_key: ${Constantes.API_KEY}")
    @GET("movie/popular")
   suspend fun traerPeliculas(): Call<ResultPelicula>
}