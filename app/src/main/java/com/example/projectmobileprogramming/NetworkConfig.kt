package com.example.projectmobileprogramming

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class NetworkConfig {
    fun getRetrofit() : Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        //base url: https://api.openweathermap.org/data/2.5/forecast?q=purwakarta,ID&appid=2ce659b9c25fc6fe3a07de4ca71d1dac
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getService() = getRetrofit().create(Weathers::class.java)

}

interface Weathers {
    @GET("data/2.5/forecast/")
    fun getWeathers(@Query("q") q : String, @Query("appid") appid : String): Call<ResultWeather>
}