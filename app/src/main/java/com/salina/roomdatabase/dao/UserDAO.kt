package com.salina.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.salina.roomdatabase.entity.Student
import com.salina.roomdatabase.entity.User
//middleware
@Dao
interface UserDAO {
    @Insert
    //suspend function can only be used in coroutines,
    //starting a function then stopping and then resuming another function
    suspend fun registerUser(user: User)

    @Query("select * from User where username=(:username) and password=(:password)")
    suspend fun checkUser(username: String, password: String): User
}