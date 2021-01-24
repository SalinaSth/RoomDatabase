package com.salina.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.salina.roomdatabase.dao.UserDAO
import com.salina.roomdatabase.entity.User

@Database(
    entities = [(User::class)],
    version = 1
)
abstract class StudentDB : RoomDatabase(){
    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        private var instance: StudentDB? = null
        fun getInstance(context: Context): StudentDB {
            if (instance == null) {
                synchronized(StudentDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StudentDB::class.java,
                "StudentDB"
            ).build()
    }
}