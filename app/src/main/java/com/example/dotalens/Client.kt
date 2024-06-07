package com.example.dotalens

import com.example.dotalens.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Client {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(Constants.TIME_OUT,TimeUnit.SECONDS)
        .writeTimeout(Constants.TIME_OUT,TimeUnit.SECONDS)
        .build()

    private lateinit var retrofit: Retrofit

    fun getRetrofit():Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit
    }
}