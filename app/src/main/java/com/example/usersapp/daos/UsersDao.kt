package com.example.usersapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.usersapp.entities.UsersEntity

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAll():LiveData<List<UsersEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(usersEntity: UsersEntity)

    @Delete
    fun deleteUser(usersEntity: UsersEntity)

}