package com.example.basicrecyclerview.recyclerview

import android.view.View

interface ItemClickListener {
    fun onItemClick(view: View, data: RecyclerData, index: Int)
}