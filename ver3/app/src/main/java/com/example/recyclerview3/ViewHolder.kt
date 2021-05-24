package com.example.recyclerview3

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    private val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun bind(data: Data) {
        tvTitle.text = data.title
        tvTime.text = data.time

        val index = adapterPosition
        if (index != RecyclerView.NO_POSITION) {
            itemView.setOnClickListener {
                listener?.onItemClick(itemView, data, adapterPosition)
            }
        }
    }
}