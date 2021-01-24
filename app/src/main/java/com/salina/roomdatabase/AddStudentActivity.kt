package com.salina.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class AddStudentActivity : AppCompatActivity() {
    private lateinit var etFullname: EditText
    private lateinit var etAge: EditText
    private lateinit var rdoGrp: RadioGroup
    private lateinit var rbtnMale: RadioButton
    private lateinit var rbtnFemale: RadioButton
    private lateinit var rbtnOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var btnAddStudent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        etFullname = findViewById(R.id.etFullname)
        etAge = findViewById(R.id.etAge)
        rdoGrp = findViewById(R.id.rdoGrp)
        rbtnMale = findViewById(R.id.rbtnMale)
        rbtnFemale = findViewById(R.id.rbtnFemale)
        rbtnOthers = findViewById(R.id.rbtnOthers)
        etAddress = findViewById(R.id.etAddress)
        btnAddStudent = findViewById(R.id.btnAddStudent)

        btnAddStudent.setOnClickListener{
            val intent = Intent(this, ViewStudentActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show()
        }
    }
}