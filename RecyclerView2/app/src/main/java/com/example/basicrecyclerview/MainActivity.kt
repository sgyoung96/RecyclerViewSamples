package com.example.basicrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicrecyclerview.recyclerview.ItemClickListener
import com.example.basicrecyclerview.recyclerview.RecyclerAdapter
import com.example.basicrecyclerview.recyclerview.RecyclerData
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ViewHolder 는 Data 를 Adapter 로 넘겨줌
 * Adapter 는 ViewHolder 와 Activity 를 연결시켜줌
 * Adapter 와 ViewHolder 는 RecyclerView 클래스를 상속받아야 함
 *
 * RecyclerView 의 item 클릭 이벤트를 위해 Activity 와 Adapter 를 연결시켜줄 Interface 를 선언
 */

class MainActivity : AppCompatActivity(), ItemClickListener {

    lateinit var adapter: RecyclerAdapter
    val data = mutableListOf<RecyclerData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 텍스트뷰를 클릭했을 때 화면에 데이터 목록이 뿌려짐
        tv_click.setOnClickListener {
            initRecyclerView()
        }
    }

    fun initRecyclerView() {
        // 리사이클러뷰 아이템 당 구분선 넣기
        // LayoutManager 는 xml 에서 선언했음(LinearLayout)
        rv_main.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        adapter = RecyclerAdapter(this)

        data.apply {
            add(RecyclerData(number = "1", text = "1234567890 첫번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "2", text = "1234567890 두번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "3", text = "1234567890 세번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "4", text = "1234567890 네번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "5", text = "1234567890 다섯번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "6", text = "1234567890 여섯번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "7", text = "1234567890 일곱번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "8", text = "1234567890 여덟번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "9", text = "1234567890 아홉번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "10", text = "1234567890 열번째 아이템을 넘깁니다."))

            add(RecyclerData(number = "11", text = "1234567890 11번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "12", text = "1234567890 12번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "13", text = "1234567890 13번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "14", text = "1234567890 14번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "15", text = "1234567890 15번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "16", text = "1234567890 16번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "17", text = "1234567890 17번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "18", text = "1234567890 18번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "19", text = "1234567890 19번째 아이템을 넘깁니다."))
            add(RecyclerData(number = "20", text = "1234567890 20번째 아이템을 넘깁니다."))
        }

        adapter.data = data
        adapter.notifyDataSetChanged()

        // 아이템 클릭 이벤트 발생을 위해..
        adapter.itemClickListener(this)

        rv_main.adapter = adapter
    }

    // 리사이클러뷰 아이템 클릭했을 때 아이템의 값을 다른 화면으로 넘겨줄 거임
    // 인터페이스의 함수 구현
    override fun onItemClick(view: View, data: RecyclerData, index: Int) {
        Intent(this@MainActivity, ReceivedItemActivity::class.java).apply {
            putExtra("data", data)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run {
            startActivity(this)
        }
    }
}