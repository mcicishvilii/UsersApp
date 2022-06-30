package com.example.usersapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Users")
data class  UsersEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int,
    val email:String
)
