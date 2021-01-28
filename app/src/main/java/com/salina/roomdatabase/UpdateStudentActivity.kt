package com.salina.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.salina.roomdatabase.db.StudentDB
import com.salina.roomdatabase.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateStudentActivity : AppCompatActivity() {
    private lateinit var etUpdateFullname: EditText
    private lateinit var etUpdateAge: EditText
//    private lateinit var rdoUpdateGrp: RadioGroup
//    private lateinit var rbtnUptMale: RadioButton
//    private lateinit var rbtnUptFemale: RadioButton
//    private lateinit var rbtnUptOthers: RadioButton
    private lateinit var etUpdateAddress: EditText
    private lateinit var etUpdateGender: EditText
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_student)
        etUpdateFullname = findViewById(R.id.etUpdateFullname)
        etUpdateAge = findViewById(R.id.etUpdateAge)
        etUpdateGender = findViewById(R.id.etUpdateGender)
//        rdoUpdateGrp = findViewById(R.id.rdoUpdateGrp)
//        rbtnUptMale = findViewById(R.id.rbtnUptMale)
//        rbtnUptFemale = findViewById(R.id.rbtnFemale)
//        rbtnUptOthers = findViewById(R.id.rbtnUptOthers)
        etUpdateAddress = findViewById(R.id.etUpdateAddress)
        btnUpdate = findViewById(R.id.btnUpdate)

        val intent = intent.getParcelableExtra<Student>("student")
        if (intent != null){
            etUpdateFullname.setText(intent.fullname)
            etUpdateAge.setText(intent.age.toString())
            etUpdateGender.setText(intent.gender)
            etUpdateAddress.setText(intent.address)
        }

        btnUpdate.setOnClickListener{
            val student = Student(fullname = etUpdateFullname.text.toString(), age = etUpdateAge.text.toString().toInt(),
            gender = etUpdateGender.text.toString(), address = etUpdateAddress.text.toString())
            student.studentId = intent!!.studentId
            CoroutineScope(Dispatchers.IO).launch {
                StudentDB.getInstance(this@UpdateStudentActivity).getStudentDAO().updateStudent(student)
                startActivity(Intent(this@UpdateStudentActivity, ViewStudentActivity::class.java))
            }

        }

    }
}

