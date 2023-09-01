package com.ggroup.greecle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val newsList: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    var onItemClick : ((News)-> Unit)? = null

    class NewsViewHolder(newsView: View): RecyclerView.ViewHolder(newsView){
        val newsImageView: ImageView = itemView.findViewById(R.id.imageView12)
        val newsNameTv: TextView = itemView.findViewById(R.id.textView22)
        val newsDescTv: TextView = itemView.findViewById(R.id.textView23)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.newsImageView.setImageResource(newsItem.newsImage)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(newsItem)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}