package com.example.usersapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.usersapp.daos.UsersDao
import com.example.usersapp.entities.UsersEntity

const val DATABASE_VERSION = 1

@Database(entities = [UsersEntity::class], version = DATABASE_VERSION, exportSchema = false)


abstract class UsersDatabase : RoomDatabase(){
        abstract fun usersDao():UsersDao

    companion object{
        @Volatile
        private var INSTANCE: UsersDatabase? = null
        fun getDatabase(context: Context):UsersDatabase{
            var tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context,
                    UsersDatabase::class.java,
                    "users_database").allowMainThreadQueries().build()
                INSTANCE = newInstance
                return newInstance
            }

        }
    }

}