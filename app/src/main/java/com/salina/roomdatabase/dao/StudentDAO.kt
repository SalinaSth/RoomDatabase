package com.salina.roomdatabase.dao

import androidx.room.*
import com.salina.roomdatabase.entity.Student

@Dao
interface StudentDAO {
    @Insert
    suspend fun addStudent(student: Student)

    @Query("SELECT * FROM STUDENT")
    suspend fun getAllStudents(): List<Student>

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

}