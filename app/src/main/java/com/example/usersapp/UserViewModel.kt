package com.example.usersapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.usersapp.daos.UsersDao
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.entities.UsersEntity
import com.example.usersapp.repo.UsersRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    var readAllData:LiveData<List<UsersEntity>>
    private var repo:UsersRepo




    init{
        val userDao = UsersDatabase.getDatabase(application).usersDao()
        repo = UsersRepo(userDao)
        readAllData = repo.getUsers
    }

    fun addUser(usersEntity: UsersEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertUser(usersEntity)
        }
    }

    fun removeUser(usersEntity: UsersEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteUser(usersEntity)
        }
    }
}