package com.example.projectmobileprogramming

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_dashboard.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val dateTime = itemView.day
    private val description = itemView.desc
    private val temperature = itemView.temp
    private val range = itemView.temp_range
    private val imageIcon = itemView.imageView

    fun bindItem(item: ListItem){
        dateTime.text = item.dt?.let { Util.getDayName(it) }
        description.text = item.weather?.get(0)?.description
        temperature.text = item.main?.temp?.let { Util.setFormatTemperature(it) }
        range.text = item.main?.tempMin?.let { Util.setFormatTemperature(it) } + " - " + item.main?.tempMax?.let { Util.setFormatTemperature(it) }
        //item.weather?.get(0)?.id?.let { Util.getArtResourceForWeatherCondition(it) }?.let { imageIcon.setImageResource(it) }
        val weatherId = item.weather?.get(0)?.id
        weatherId?.let { Util.getArtResourceForWeatherCondition(it) }?.let { imageIcon.setImageResource(it) }
    }

}
