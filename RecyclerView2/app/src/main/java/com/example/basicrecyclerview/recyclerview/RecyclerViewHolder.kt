package com.example.basicrecyclerview.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicrecyclerview.R
import org.w3c.dom.Text

class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvNumber = itemView.findViewById<TextView>(R.id.tv_number)
    val tvText = itemView.findViewById<TextView>(R.id.tv_text)

    // 1. 리사이클러뷰 아이템 클릭 시 이벤트 발생을 위한 변수 선언
    lateinit var clickListener: ItemClickListener

    fun bind(data: RecyclerData) {
        tvNumber.text = data.number
        tvText.text = data.text

        // 3. 리사이클러뷰 아이템 클릭 시 이벤트 발생을 위한 로직
        // 만약 인덱스가 없지 않다면, 아이템을 클릭했을 때, 인터페이스로
        // 해당 item 과, item 에 포함된 data 와, item 의 index 를 넘김!
        val index = adapterPosition
        if (index != RecyclerView.NO_POSITION) {
            itemView.setOnClickListener {
                clickListener.onItemClick(itemView, data, adapterPosition)
            }
        }
    }

    // 2. 리사이클러뷰 아이템 클릭 시 이벤트 발생을 위한 함수 선언
    fun itemClickListener(listener: ItemClickListener) {
        this.clickListener = listener
    }
}