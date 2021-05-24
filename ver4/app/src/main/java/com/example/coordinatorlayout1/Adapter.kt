package com.example.coordinatorlayout1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    var datas = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(datas[position])
        if (position < datas.size) {
//            holder.tvTitle.text = datas[position].toString()
            holder.bind(datas[position])
        }
    }

}