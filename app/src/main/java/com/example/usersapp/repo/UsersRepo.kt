package com.example.usersapp.repo

import android.content.Context
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.entities.UsersEntity

class UsersRepo (context: Context){
    private val database = UsersDatabase.getDatabase(context)

    suspend fun insertUser(usersEntity: UsersEntity){
        database.usersDao().insertUser(usersEntity)
    }

    suspend fun getAllUsers(): List<UsersEntity> {
        return database.usersDao().getAll()
    }

    suspend fun deleteUser(usersEntity: UsersEntity){
        database.usersDao().deleteUser(usersEntity)
    }

    companion object{
        private var instance: UsersRepo? = null

        fun getInstance(context: Context):UsersRepo{
            return if (instance != null ){
                instance!!
            }else{
                instance = UsersRepo(context)
                instance!!
            }
        }
    }
}