package com.ggroup.greecle.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ggroup.greecle.models.Station
import com.ggroup.greecle.R

class StationAdapter(private val stationsList: ArrayList<Station>):
    RecyclerView.Adapter<StationAdapter.StationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.station_card_item, parent, false)
        return StationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return stationsList.size
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val currentItem = stationsList[position]
        holder.stationName.text = currentItem.stationName
        holder.stationAvl.text = if (currentItem.stationAvailability) "Available" else "Unavailable"
        Log.d("Adapter", "Bind triggered")
    }

    class StationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

//        val stationImg: ImageView = itemView.findViewById(R.id.stationImg)
        val stationName: TextView = itemView.findViewById(R.id.stationName)
        val stationAvl: TextView = itemView.findViewById(R.id.availability)

    }
}