package com.example.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    val data = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        adapter = Adapter(this)
        rvContainer.adapter = adapter // 코틀린 xml id 값 호환 기능

        data.apply {
            add(Data(name = "테스트1"))
            add(Data(name = "테스트2"))
            add(Data(name = "테스트3"))
            add(Data(name = "테스트4"))
            add(Data(name = "테스트5"))
            add(Data(name = "테스트6"))
            add(Data(name = "테스트7"))
            add(Data(name = "테스트8"))
            add(Data(name = "테스트9"))
            add(Data(name = "테스트10"))
            add(Data(name = "테스트11"))
            add(Data(name = "테스트12"))
            add(Data(name = "테스트13"))
            add(Data(name = "테스트14"))

//            adapter.data = data
//            adapter.notifyDataSetChanged()
        }   // --------------------------------------> 데이터 할당은 다 잘 되는 것 확인
        adapter.data = data
        adapter.notifyDataSetChanged()
    }
}