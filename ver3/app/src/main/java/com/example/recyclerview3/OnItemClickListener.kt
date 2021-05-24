package com.example.recyclerview3

import android.view.View

interface OnItemClickListener {
    fun onItemClick(v: View, data: Data, index: Int)
}