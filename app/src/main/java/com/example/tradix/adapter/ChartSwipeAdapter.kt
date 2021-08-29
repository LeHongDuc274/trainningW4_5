package com.example.tradix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R

class ChartSwipeAdapter : RecyclerView.Adapter<ChartSwipeAdapter.ViewHolder>() {

    var listChart: MutableList<Int> = mutableListOf()
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_neo_chart,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.iv_chart).setImageResource(listChart[position])
    }

    override fun getItemCount(): Int {
       return listChart.size
    }
}