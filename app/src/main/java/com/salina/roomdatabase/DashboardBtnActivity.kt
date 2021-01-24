package com.salina.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardBtnActivity : AppCompatActivity() {
    private lateinit var btnAddStudents: Button
    private lateinit var btnViewStudents: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_btn)
        btnAddStudents = findViewById(R.id.btnAddStudents)
        btnViewStudents = findViewById(R.id.btnViewStudents)

        btnAddStudents.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
        btnViewStudents.setOnClickListener {
            val intent = Intent(this, ViewStudentActivity::class.java)
            startActivity(intent)
        }
    }
}