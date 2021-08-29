package com.example.tradix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.model.Model1

class ListIndexAdapter() : RecyclerView.Adapter<ListIndexAdapter.ViewHolder>() {
    var itemClick : ((Int) -> Unit)? = null
    var list  :MutableList<Model1> = mutableListOf()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_index,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_item_idex_1).text = list[position].text1
        holder.itemView.findViewById<TextView>(R.id.tv_item_idex_2).text = list[position].text2
        holder.itemView.findViewById<TextView>(R.id.tv_item_idex_3).text = list[position].text3
        holder.itemView.findViewById<TextView>(R.id.tv_item_idex_4).text = list[position].text4
        holder.itemView.findViewById<TextView>(R.id.tv_item_idex_5).text = list[position].text5
        holder.itemView.setOnClickListener {
            itemClick?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun setClick(action:(Int)->Unit) {
        itemClick = action
    }
}