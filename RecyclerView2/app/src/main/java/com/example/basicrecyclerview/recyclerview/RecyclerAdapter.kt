package com.example.basicrecyclerview.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicrecyclerview.R

class RecyclerAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewHolder>(), ItemClickListener {

    var data = mutableListOf<RecyclerData>()

    // 리사이클러뷰의 아이템을 클릭했을 때 이벤트 발생시키기 위한 변수 선언
    lateinit var listener: ItemClickListener

    /**
     * 기본 3개 override 해야 하는 함수들
     * getItemCount, onCreateViewHolder, onBindViewHolder
     */
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false)

        // 아이템 클릭 이벤트 발생을 위해...
        val viewHoler = RecyclerViewHolder(view)
        viewHoler.itemClickListener(this)

//        return RecyclerViewHolder(view)
        return viewHoler
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    /**
     * 리사이클러뷰의 아이템 클릭 이벤트 발생 시 처리할 함수
     * itemClickListener, onItemClick
     */
    fun itemClickListener(listener: ItemClickListener) {
        this.listener = listener
    }

    override fun onItemClick(view: View, data: RecyclerData, index: Int) {
        listener.onItemClick(view, data, index)
    }
}