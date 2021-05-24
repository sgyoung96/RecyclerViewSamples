package com.example.coordinatorlayout1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTitle = itemView.findViewById<TextView>(R.id.tvText)

    fun bind(data: Data) {
        tvTitle.text = data.text
    }
}