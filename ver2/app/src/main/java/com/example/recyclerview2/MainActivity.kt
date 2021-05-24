package com.example.recyclerview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {

    lateinit var adapter: Adapter
    val datas = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()

        tvTotal.text = "검색결과 " + datas.size
    }

    private fun initRecycler() {
        adapter = Adapter(this)
        rvContainer.adapter = adapter

        datas.apply {
            add(Data(title = "MM월 n주차 주간 리포트", date = "2020.11.18 14:00"))
            add(Data(title = "MM월 n주차 주간 리포트", date = "2020.11.18 14:00"))
            add(Data(title = "MM월 리포트", date = "2020.11.18 14:00"))
            add(Data(title = "과소비 주의하세요!", date = "2020.11.18 14:00"))
            add(Data(title = "결제 계좌 잔고 부족", date = "2020.11.18 14:00"))
            add(Data(title = "결제 계좌 잔고 충분", date = "2020.11.18 14:00"))
        }

        adapter.datas = datas
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickListener(this)
    }

    override fun onItemClick(v: View, data: Data, index: Int) {
        Intent(this@MainActivity,
            FirstActivity::class.java).apply {
            putExtra("data", data)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }
}