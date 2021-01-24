package com.salina.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var text_input_usName: TextInputLayout
    private lateinit var text_input_pwd: TextInputLayout
    private lateinit var btnLogin: Button
    private lateinit var tvSignup : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_input_usName = findViewById(R.id.text_input_usName)
        text_input_pwd = findViewById(R.id.text_input_pwd)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignup = findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener {
            if (TextUtils.isEmpty(text_input_usName.editText?.text)){
                text_input_usName.editText?.error = "Username is empty"
                text_input_usName.editText?.requestFocus()
                return@setOnClickListener
            }else if(TextUtils.isEmpty(text_input_pwd.editText?.text)){
                text_input_pwd.editText?.error = "Password is empty"
                text_input_pwd.editText?.requestFocus()
                return@setOnClickListener
            }
            login()
        }

        val text = "No account? Signup here".toSpannable()
        text[text.length-11 until text.length+1] = object: ClickableSpan(){
            override fun onClick(widget: View) {
                val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
        tvSignup.movementMethod = LinkMovementMethod()
        tvSignup.text = text
    }
    private fun login(){
        val intent = Intent(this, DashboardBtnActivity::class.java)
        startActivity(intent)
    }
}