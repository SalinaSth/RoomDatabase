package com.salina.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateStudentActivity : AppCompatActivity() {
    private lateinit var etUpdateFullname: EditText
    private lateinit var etUpdateAge: EditText
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_student)
        etUpdateFullname = findViewById(R.id.etUpdateFullname)
        etUpdateAge = findViewById(R.id.etUpdateAge)
        btnUpdate = findViewById(R.id.btnUpdate)

        btnUpdate.setOnClickListener{

        }

    }
}