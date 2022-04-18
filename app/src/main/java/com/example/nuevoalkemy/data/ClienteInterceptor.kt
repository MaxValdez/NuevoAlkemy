package com.example.nuevoalkemy.data

import okhttp3.Interceptor
import okhttp3.Response

class ClienteInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("api_key:",Constantes.API_KEY).build()
        return chain.proceed(request)
    }
}