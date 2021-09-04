package com.example.tradix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.VIEW_TYPE_HEADER_1
import com.example.tradix.VIEW_TYPE_ITEM_1
import com.example.tradix.VIEW_TYPE_ITEM_2


class MenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var listItem = mutableListOf<ItemMenu>()

    inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return listItem[position].type
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_HEADER_1 -> return ViewHolder1(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_menu_view_type_1, parent, false)
            )
            VIEW_TYPE_ITEM_1 -> return ViewHolder2(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_menu_view_type_2, parent, false)
            )
        }
        return ViewHolder3(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu_view_type_3, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = listItem[position]
        when (holder.itemViewType) {
            VIEW_TYPE_HEADER_1 -> {
                holder.itemView.findViewById<TextView>(R.id.tv_1_type_1).text = item.name
            }
            VIEW_TYPE_ITEM_1 -> {
                holder.itemView.findViewById<TextView>(R.id.tv_1_type_2).text = item.name
                item.icon?.let {
                    holder.itemView.findViewById<ImageView>(R.id.iv_icon_type_2).setImageResource(
                        it
                    )
                }
            }
            VIEW_TYPE_ITEM_2 -> {
                holder.itemView.findViewById<TextView>(R.id.tv_1_type_3).text = item.name
                item.icon?.let {
                    holder.itemView.findViewById<ImageView>(R.id.iv_icon_type_3).setImageResource(
                        it
                    )
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}

data class ItemMenu(val icon: Int?, val name: String, val type: Int)