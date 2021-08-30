package com.example.tradix.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R

class NewAdapter(val context : Context) : RecyclerView.Adapter<NewAdapter.ViewHolder>() {
    var itemClick: ((Int) -> Unit)? = null
    var listNewItem = mutableListOf<NewItem>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_new, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listNewItem[position]
        holder.itemView.findViewById<ImageView>(R.id.iv_item_view).setImageResource(item.img)
        holder.itemView.findViewById<TextView>(R.id.tv_item_new_1).text = item.index
        holder.itemView.findViewById<TextView>(R.id.tv_item_new_2).text = item.time
        holder.itemView.findViewById<TextView>(R.id.tv_item_new_3).text = item.name
//        val string: String = Resources.getSystem().getString(R.string.text_disc)
        val string:String = context.getString(R.string.text_disc)
        holder.itemView.findViewById<TextView>(R.id.tv_item_new_4).text = string
        holder.itemView.findViewById<ImageButton>(R.id.btn_item_new_goto).setOnClickListener {
            itemClick?.invoke(position)
        }
    }

    fun setClick(action: (Int) -> Unit) {
        itemClick = action
    }

    override fun getItemCount(): Int {
        return listNewItem.size
    }
}

data class NewItem(
    val img: Int,  //R.drawble
    val index: String,
    val time: String,
    val name: String,
    val descrip: Int //from R.string
)