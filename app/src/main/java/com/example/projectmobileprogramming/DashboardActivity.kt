package com.example.projectmobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dashboard.*
import androidx.recyclerview.widget.LinearLayoutManager
import okhttp3.*
import java.io.IOException

class DashboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //run("https://api.openweathermap.org/data/2.5/forecast?q=purwakarta,ID&appid=2ce659b9c25fc6fe3a07de4ca71d1dac")

        val btnCari : Button =findViewById(R.id.btnCari)
        btnCari.setOnClickListener(View.OnClickListener {
            val cariLokasi = searchLokasi.text.toString()
            NetworkConfig().getService().getWeathers("$cariLokasi,ID", "2ce659b9c25fc6fe3a07de4ca71d1dac").enqueue(object : retrofit2.Callback<ResultWeather> {

                override fun onResponse(call: retrofit2.Call<ResultWeather>, response: retrofit2.Response<ResultWeather>) {
                    var item = response.body()
                    Log.d("response", response.body().toString())

                    txtKota.text = item?.city?.name
                    txtTanggal.text = item?.list?.get(0)?.dt?.let { Util.getDayName(it) }
                    text_temp.text = item?.list?.get(0)?.main?.temp?.let { Util.setFormatTemperature(it) }
                    text_temp_min_max.text = item?.list?.get(0)?.main?.tempMin?.let { Util.setFormatTemperature(it) } + " - " + item?.list?.get(0)?.main?.tempMax?.let { Util.setFormatTemperature(it) }
                    text_desc.text = item?.list?.get(0)?.weather?.get(0)?.description.toString()
                    item?.list?.get(0)?.weather?.get(0)?.id?.let { Util.getArtResourceForWeatherCondition(it) }?.let { image_desc.setImageResource(it) }

                    var list = item?.list
                    var itemAdp = ItemAdapter(list as List<ListItem>)

                    recycler_view_container.apply {
                        layoutManager = LinearLayoutManager(this@DashboardActivity)
                        adapter = itemAdp
                    }

                }

                override fun onFailure(call: retrofit2.Call<ResultWeather>, t: Throwable) {
                    Log.d("error response service", t.message.toString())

                    Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()
                }
            })
        })



    }

    fun run(url: String){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }
}