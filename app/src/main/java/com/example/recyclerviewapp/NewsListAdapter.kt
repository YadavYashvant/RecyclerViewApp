package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val listener: newsItemClicked): RecyclerView.Adapter<NewsViewsHolder>() {

    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_views,parent,false)
        val Viewholder = NewsViewsHolder(view)
        view.setOnClickListener {
            listener.OnItemClicked(items[Viewholder.adapterPosition])
        }
        return Viewholder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewsHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
    }

    fun updateNews(updateNews: ArrayList<News>) {
        items.clear()
        items.addAll(updateNews)

        notifyDataSetChanged()
    }
}
class NewsViewsHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.titleItem)
}

interface newsItemClicked {
    fun OnItemClicked(Item: News)
}