package com.example.recyclerview3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * RecyclerView2 프로젝트의 인터페이스와 홀더를 각각 다른 파일로 빼서 만든 버젼임.
 * => RecyclerView의 item 하나를 클릭 시, 해당 item의 title TextView를 다음 화면으로 값 넘기면서 화면 전환, 이 때, 클릭 이벤트 인터페이스를 다른 파일로 만들어서 처리.
 *
 * 1. ViewHolder에서
 *      itemView: View
 *      itemView.setOnClickListener{}
 *      listener: OnItemClickListener
 *      itemView.setOnClickListener 안에 { listener.onItemClick() }
 *   -> View 내장함수 setOnClickListener 를 호출하면서 인터페이스의 함수인 onItemClick 함 호출(매개변수 전달)
 *
 * 2. OnItemClickListener 인터페이스가 ViewHolder로부터 매개변수 전달받음
 *
 * 3. Adapter가 OnItemClickListener를 상속받아서 onItemClick 구현.
 *    다시 OnItemClickListener 인터페이스로 onItemClick 함수 호출하면서 매개변수 넘김
 *
 * 4. MainActivity 가 OnItemClickListener를 상속받아서 실제 로직 구현 (intent 처리)
 */

class MainActivity : AppCompatActivity(), OnItemClickListener {

    lateinit var adapter: Adapter
    val datas = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()

        tvTotal.text = "검색결과 : " + datas.size
    }

    private fun initRecycler() {
        adapter = Adapter(this)

        this.datas.apply {
            add(Data(title = "MM월 n주차 주간 리포트", time = "2020.11.18 14:00"))
            add(Data(title = "MM월 n주차 주간 리포트", time = "2020.11.18 14:00"))
            add(Data(title = "MM월 리포트", time = "2020.11.18 14:00"))
            add(Data(title = "과소비 주의하세요!", time = "2020.11.18 14:00"))
            add(Data(title = "결제 계좌 잔고 부족", time = "2020.11.18 14:00"))
            add(Data(title = "결제 계좌 잔고 충분", time = "2020.11.18 14:00"))
        }

        adapter.datas = datas
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickListener(this)
        rvContainer.layoutManager = LinearLayoutManager(this)
        rvContainer.adapter = adapter

    }

    override fun onItemClick(v: View, data: Data, index: Int) {
        Intent(this@MainActivity, FirstActivity::class.java).apply {
            putExtra("data", data)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run { startActivity(this) }
    }
}