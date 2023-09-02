package com.ggroup.greecle.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.ggroup.greecle.models.Station
import com.ggroup.greecle.R
import com.google.android.gms.maps.model.LatLng

class StationAdapter(private var stationsList: ArrayList<Station>):
    RecyclerView.Adapter<StationAdapter.StationViewHolder>() {

    var onItemClick: ((LatLng)->Unit)? = null
    var onVisitClick: ((String?)->Unit)? = null

    fun setFilteredList(list: ArrayList<Station>) {
        stationsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.station_card_item, parent, false)
        return StationViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return stationsList.size
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val currentItem = stationsList[position]
        var tagBg = 0
        holder.stationName.text = currentItem.stationName
        if (currentItem.stationAvailability) {
            holder.stationAvl.text = "Available"
            tagBg = R.drawable.rounded_green_bg
            holder.stationAvl.setBackgroundResource(tagBg)
            holder.visitButton.visibility = View.VISIBLE
            holder.visitButton.setOnClickListener {
                onVisitClick?.invoke(currentItem.stationName)
            }
        }
        else {
            holder.stationAvl.text = "Unavailable"
            tagBg = R.drawable.rounded_red_bg
            holder.stationAvl.setBackgroundResource(tagBg)
            holder.visitButton.visibility = View.INVISIBLE
        }

        val coord = currentItem.stationCoordinate
        holder.coord = LatLng(coord.latitude, coord.longitude)

        holder.item.setOnClickListener {
            onItemClick?.invoke(holder.coord)
        }

    }

    class StationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

//        val stationImg: ImageView = itemView.findViewById(R.id.stationImg)
        val stationName: TextView = itemView.findViewById(R.id.stationName)
        val stationAvl: TextView = itemView.findViewById(R.id.availability)
        val visitButton: AppCompatButton = itemView.findViewById(R.id.visitButton)
        var coord: LatLng = LatLng(0.0,0.0)
        val item: View = itemView
    }
}