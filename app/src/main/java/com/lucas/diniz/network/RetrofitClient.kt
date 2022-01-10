package com.lucas.diniz.network

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient : AppCompatActivity() {

    private const val BASE_URL = "https://5f5a8f24d44d640016169133.mockapi.io/api/"

    fun <T> getApi(service: Class<T>) =
        buildRetrofit()
            .create(service)

    private fun buildRetrofit() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

}
