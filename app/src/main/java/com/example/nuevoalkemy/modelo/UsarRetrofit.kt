package com.example.nuevoalkemy.modelo

import com.example.nuevoalkemy.data.ClienteInterceptor
import com.example.nuevoalkemy.data.Constantes
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class UsarRetrofit() {

    val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constantes.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .client(tomarCLiente())
        .build()

    private fun tomarCLiente(): OkHttpClient {
        var cliente = OkHttpClient.Builder().addInterceptor(ClienteInterceptor()).build()
        return cliente

    }
    /*fun usarRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(Constantes.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build()
    }*/
}