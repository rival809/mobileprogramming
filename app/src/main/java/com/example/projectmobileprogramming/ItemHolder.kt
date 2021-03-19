package com.example.projectmobileprogramming

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val dateTime = itemView.day
    private val description = itemView.desc
    private val temperature = itemView.temp
    private val range = itemView.temp_range

    fun bindItem(item: ListItem){
        dateTime.text = item.dt.toString()
        description.text = item.weather?.get(0)?.description
        temperature.text = item.main?.temp.toString()
        range.text = item.main?.tempMin.toString()+ " - " + item.main?.tempMax.toString()
    }

}
