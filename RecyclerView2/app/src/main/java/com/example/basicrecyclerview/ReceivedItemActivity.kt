package com.example.basicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicrecyclerview.recyclerview.RecyclerData
import kotlinx.android.synthetic.main.rv_items.*

class ReceivedItemActivity : AppCompatActivity() {

    lateinit var data: RecyclerData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_received_item)

        data = intent.getSerializableExtra("data") as RecyclerData

        tv_number.text = data.number
        tv_text.text = data.text
    }
}