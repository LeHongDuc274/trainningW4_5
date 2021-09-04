package com.example.tradix.adapter

import android.graphics.Canvas
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R
import com.example.tradix.model.Model1

class ListIndexAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_LOADING = 1
    }

    private var itemClick: ((Int) -> Unit)? = null
    private var loadMoreClick: (() -> Unit)? = null
    private var list: MutableList<Model1?> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class ViewHolderLoading(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_LOADING) {
            return ViewHolderLoading(
                LayoutInflater.from(parent.context).inflate(R.layout.item_load_more, parent, false)
            )
        } else return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_index, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VIEW_TYPE_ITEM) {
            holder.itemView.findViewById<TextView>(R.id.tv_item_idex_1).text = list[position]?.text1
            holder.itemView.findViewById<TextView>(R.id.tv_item_idex_2).text = list[position]?.text2
            holder.itemView.findViewById<TextView>(R.id.tv_item_idex_3).text = list[position]?.text3
            holder.itemView.findViewById<TextView>(R.id.tv_item_idex_4).text = list[position]?.text4
            holder.itemView.findViewById<TextView>(R.id.tv_item_idex_5).text = list[position]?.text5
            holder.itemView.setOnClickListener {
                itemClick?.invoke(position)
            }
        } else if (holder.itemViewType == VIEW_TYPE_LOADING) {
            holder.itemView.findViewById<Button>(R.id.btn_load_more).setOnClickListener {
                loadMoreClick?.invoke()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position] == null) return VIEW_TYPE_LOADING
        else return VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(listData: MutableList<Model1?>) {
        list = listData
        notifyDataSetChanged()
    }

    fun setClick(action: (Int) -> Unit) {
        itemClick = action
    }

    fun setLoadMoreClick(action: () -> Unit) {
        loadMoreClick = action
    }
}
