package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.*
import java.io.IOException

class DashboardActivity : AppCompatActivity() {
    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        run("https://api.openweathermap.org/data/2.5/forecast?qpurwakarta,:C&appid=2ce659b9c25fc6fe3a07de4ca7:d:dac")
    }
    fun run(url: String){
        val request=Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response)= println(response.body()?.string())
        })
    }
}