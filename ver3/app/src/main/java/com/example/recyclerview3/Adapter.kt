package com.example.recyclerview3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>(), OnItemClickListener {

    var datas = mutableListOf<Data>()
    private var listener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.setOnItemClickListener(this)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onItemClick(v: View, data: Data, index: Int) {
        listener?.onItemClick(v, data, index)
    }
}