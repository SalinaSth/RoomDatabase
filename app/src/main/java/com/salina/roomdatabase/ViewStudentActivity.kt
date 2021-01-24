package com.salina.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salina.roomdatabase.adapter.StudentAdapter
import com.salina.roomdatabase.model.Student

class ViewStudentActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var lstStudent = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)
        recyclerView = findViewById(R.id.recyclerView)
        loadStudentDetails()
        val adapter = StudentAdapter(lstStudent, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    private fun loadStudentDetails(){
        lstStudent.add(Student(1, "Salina Stha", 20, "Female", "Kupondole"))
        lstStudent.add(Student(2, "Meezu Lawot", 20, "Female", "Tokha"))
        lstStudent.add(Student(3, "Reshika Stha", 20, "Female", "Bkt"))
    }
}