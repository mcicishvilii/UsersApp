package com.example.usersapp.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.usersapp.daos.UsersDao
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.entities.UsersEntity

class UsersRepo(private val usersDao: UsersDao){

    val getUsers: LiveData<List<UsersEntity>> = usersDao.getAll()

    suspend fun insertUser(usersEntity: UsersEntity){
        usersDao.addUser(usersEntity)
    }

    suspend fun deleteUser(usersEntity: UsersEntity){
        usersDao.deleteUser(usersEntity)
    }
}
