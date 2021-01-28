package com.salina.roomdatabase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.salina.roomdatabase.adapter.StudentAdapter
import com.salina.roomdatabase.db.StudentDB
//import com.salina.roomdatabase.adapter.StudentAdapter
import com.salina.roomdatabase.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewStudentActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)
        recyclerView = findViewById(R.id.recyclerView)
        refreshLayout = findViewById(R.id.refreshLayout)

        refreshView()
        refreshLayout.setOnRefreshListener {
            refreshView()
        }
    }

    private fun refreshView(){
        refreshLayout.isRefreshing = true
        CoroutineScope(Dispatchers.IO).launch {
            val lstStudent = StudentDB.getInstance(this@ViewStudentActivity)
                    .getStudentDAO().getAllStudents()

            withContext(Main){
                recyclerView.adapter = StudentAdapter(lstStudent, this@ViewStudentActivity)
                recyclerView.layoutManager = LinearLayoutManager(this@ViewStudentActivity)
                refreshLayout.isRefreshing = false
            }
        }
    }
}