package com.salina.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import com.salina.roomdatabase.entity.User

@Dao
interface UserDAO {
    @Insert
    suspend fun registerUser(user: User)
}