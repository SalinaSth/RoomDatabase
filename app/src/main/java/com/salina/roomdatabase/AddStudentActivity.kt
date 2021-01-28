package com.salina.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.salina.roomdatabase.db.StudentDB
import com.salina.roomdatabase.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddStudentActivity : AppCompatActivity() {
    private lateinit var etFullname: EditText
    private lateinit var etAge: EditText
    private lateinit var rdoGrp: RadioGroup
    private lateinit var rbtnMale: RadioButton
    private lateinit var rbtnFemale: RadioButton
    private lateinit var rbtnOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var btnAddStudent: Button
    var gender = ""
    //private var lstStudent = ArrayList<Student>()
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
            saveStudent()
        }
    }
    private fun saveStudent(){
        val fullname = etFullname.text.toString()
        val age = etAge.text.toString().toInt()
        loadGender()
        val address = etAddress.text.toString()

        val student = Student(fullname, age, gender, address)
        CoroutineScope(Dispatchers.IO).launch {
            StudentDB.getInstance(this@AddStudentActivity)
                    .getStudentDAO()
                    .addStudent(student)
            withContext(Main){
                Toast.makeText(this@AddStudentActivity, "Student Added", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadGender(){
        rdoGrp.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            var id: Int = rdoGrp.checkedRadioButtonId
            when (id) {
                R.id.rbtnMale -> {
                    gender = rbtnMale.text.toString()
                }
                R.id.rbtnFemale -> {
                    gender = rbtnFemale.text.toString()
                }
                R.id.rbtnOthers -> {
                    gender = rbtnOthers.text.toString()
                }
            }
        })
    }
}