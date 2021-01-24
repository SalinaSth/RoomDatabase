package com.salina.roomdatabase.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.salina.roomdatabase.R
import com.salina.roomdatabase.UpdateStudentActivity
import com.salina.roomdatabase.model.Student

class StudentAdapter(
    val lstStudent: ArrayList<Student>,
    val context: Context
):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvFullname: TextView
        val tvAge: TextView
        val imgBtnEdit: ImageButton
        val imgBtnDelete: ImageButton

        init {
            tvFullname = view.findViewById(R.id.tvFullname)
            tvAge = view.findViewById(R.id.tvAge)
            imgBtnEdit = view.findViewById(R.id.imgBtnEdit)
            imgBtnDelete = view.findViewById(R.id.imgBtnDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvFullname.text = student.Fullname
        holder.tvAge.text = student.Age.toString()

        holder.imgBtnDelete.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                showDeleteDialog()
            }
        })
        holder.imgBtnEdit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(context, UpdateStudentActivity::class.java)
                context.startActivity(intent)
            }

        })
    }
    private fun showDeleteDialog(){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete Student")
        builder.setMessage("Are you sure you want to delete ?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes"){dialogInterface, which: Int ->
            Toast.makeText(context, "Clicked Yes", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){dialogInterface, which: Int ->
            Toast.makeText(context, "Clicked No", Toast.LENGTH_LONG).show()
        }
        val alertDialog: AlertDialog? = builder.create()
        alertDialog!!.setCancelable(true)
        alertDialog.show()

    }
}