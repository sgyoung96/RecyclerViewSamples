package com.example.recyclerview1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var data = mutableListOf<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        private val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)

        fun bind(item: Data) {
            tvName.text = item.name
            // 이미지 할당하는 법?
        }
    }
}