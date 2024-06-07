package com.example.dotalens.api

import com.example.dotalens.model.AllHeroesState
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("heroStats")
    fun getAllHeroes():Call<AllHeroesState>
}