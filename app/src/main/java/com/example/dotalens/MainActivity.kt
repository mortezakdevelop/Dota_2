package com.example.dotalens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dotalens.adapter.AllHeroesAdapter
import com.example.dotalens.api.ApiService
import com.example.dotalens.databinding.ActivityMainBinding
import com.example.dotalens.model.AllHeroesState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val apiService by lazy {
        Client().getRetrofit().create(ApiService::class.java)
    }

    private val allHeroesAdapter by lazy {
        AllHeroesAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllHeroesFromServer()
    }

    private fun getAllHeroesFromServer(){
        binding.apply {
            heroesProgressbar.visibility = View.VISIBLE
            val callHeroesApi = apiService.getAllHeroes()
            callHeroesApi.enqueue(object : Callback<AllHeroesState> {
                override fun onResponse(
                    call: Call<AllHeroesState>,
                    response: Response<AllHeroesState>
                ) {
                    Log.d("TAG", "onResponse: ${response.message()}")
                    heroesProgressbar.visibility = View.GONE
                    if (response.isSuccessful) {
                        response.body()?.let {
                            allHeroesAdapter.differ.submitList(it)
                            rvHeroes.apply {
                                layoutManager = LinearLayoutManager(this@MainActivity)
                                adapter = allHeroesAdapter
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<AllHeroesState>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message} ")
                }

            })
        }
    }
}