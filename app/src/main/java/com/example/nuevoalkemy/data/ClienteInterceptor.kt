package com.example.nuevoalkemy.data

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class ClienteInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val url: HttpUrl = chain.request().url().newBuilder()
            .addQueryParameter("api_key", Constantes.API_KEY)
            .build()
        val request=chain.request().newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request().newBuilder().addHeader("api_key:",Constantes.API_KEY).build()
//        return chain.proceed(request)
//    }
}