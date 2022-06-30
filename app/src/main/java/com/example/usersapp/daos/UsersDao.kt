package com.example.usersapp.daos

import androidx.room.*
import com.example.usersapp.entities.UsersEntity

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAll():List<UsersEntity>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(usersEntity: UsersEntity)
    @Query("DELETE FROM  users")
    fun deleteAll()
    @Delete
    fun deleteUser(usersEntity: UsersEntity)
    @Update
    fun udpateBookModel(usersEntity: UsersEntity)
}