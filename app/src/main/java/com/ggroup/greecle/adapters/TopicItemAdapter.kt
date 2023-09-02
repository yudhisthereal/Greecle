package com.ggroup.greecle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ggroup.greecle.R
import com.ggroup.greecle.models.TopicItem

class TopicItemAdapter(private val topicItemList: List<TopicItem>) :
    RecyclerView.Adapter<TopicItemAdapter.TopicItemViewHolder>() {

    var onItemClick : ((TopicItem)-> Unit)? = null

    class TopicItemViewHolder(topicItemView: View): RecyclerView.ViewHolder(topicItemView){
        val itemImageView: ImageView = itemView.findViewById(R.id.imageView12)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.today_topic_item, parent,false)
        return TopicItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topicItemList.size
    }

    override fun onBindViewHolder(holder: TopicItemViewHolder, position: Int) {
        val topicItem = topicItemList[position]
        holder.itemImageView.setImageResource(topicItem.topicItemImage)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(topicItem)
        }
    }
}