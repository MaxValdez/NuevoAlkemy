package com.example.nuevoalkemy.modelo

import com.example.nuevoalkemy.data.Constantes
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class UsarRetrofit {

    fun usarRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(Constantes.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build()
    }
}