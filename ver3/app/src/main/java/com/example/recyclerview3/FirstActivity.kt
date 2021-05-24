package com.example.recyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    lateinit var datas: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        datas = intent.getSerializableExtra("data") as Data

        tvFirstActivity.text = datas.title
    }
}