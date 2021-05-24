package com.example.coordinatorlayout1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rv_items.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    val datas = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar) // ------------> 여기서 터진다.

        initRecycler()
    }

    private fun initRecycler() {
        adapter = Adapter(this)

        this.datas.apply {
            add(Data(text = "1"))
            add(Data(text = "2"))
            add(Data(text = "3"))
            add(Data(text = "4"))
            add(Data(text = "5"))
            add(Data(text = "6"))
            add(Data(text = "7"))
            add(Data(text = "8"))
            add(Data(text = "9"))
            add(Data(text = "10"))
            add(Data(text = "11"))
            add(Data(text = "12"))
            add(Data(text = "13"))
            add(Data(text = "14"))
        }

        adapter.datas = datas
        adapter.notifyDataSetChanged()
        rvContainer.layoutManager = LinearLayoutManager(this)
        rvContainer.adapter = adapter

//        setSupportActionBar(toolbar) // --------------> RuntimeInit에서 터진다.
    }
}