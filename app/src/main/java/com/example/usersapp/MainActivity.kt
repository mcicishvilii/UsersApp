package com.example.usersapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usersapp.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {

    val firstnames = mutableListOf<String>()
    val deletedUsers = mutableListOf<String>()




    private lateinit var b: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)


//        val lastnames = mutableListOf<String>()
//        val ages = mutableListOf<String>()
//        val emails = mutableListOf<String>()




//        val lastname = b.etLastName.text
//        val age = b.etAge.text
//        val email = b.etEmail.text



        b.btnAddUser.setOnClickListener {
            addUserAndCheckforDuplicates()
        }

        b.btnRemoveUser.setOnClickListener {
            removeUser()
        }

        b.btnUpdateUser.setOnClickListener {
//            updateUser()
        }




    }


    private fun addUserAndCheckforDuplicates(){

        val firstName = b.etFirstName.text

        if(firstnames.contains("$firstName")){
            b.tvSuccessError.text = "Error, user $firstName already exists"
            b.tvSuccessError.setTextColor(Color.RED)
        }

        else if (!firstName.isNullOrEmpty()) {
            firstnames.add(firstName.toString())
            b.tvSuccessError.setTextColor(Color.GREEN)
            b.tvSuccessError.text = "$firstName added"
            b.tvActiveUsers.text = "Active Users: ${firstnames.size}"
        }

        else {
            b.tvSuccessError.text = "Error"
            b.tvSuccessError.setTextColor(Color.RED)
        }
    }

    private fun removeUser(){
        val firstName = b.etFirstName.text
        if(firstnames.contains("$firstName")){
            firstnames.remove(firstName.toString())
            b.tvSuccessError.text = "user $firstName removed"
            b.tvSuccessError.setTextColor(Color.GREEN)
            deletedUsers.add(firstName.toString())
            b.tvDeletedUsers.text = "Deleted Users: ${deletedUsers.size}"
            b.tvActiveUsers.text = "Active Users: ${firstnames.size}"
        }else{
            b.tvSuccessError.text = "user not found"
            b.tvSuccessError.setTextColor(Color.RED)
        }
    }

//    private fun updateUser(){
//        val firstNameFromInput = b.etFirstName.text
//
//        if(firstnames.contains("$firstName")){
//            firstnames.remove(firstName.toString())
//        }
//    }
}

//
//
//!lastname.isNullOrEmpty() -> {lastnames.add(lastname.toString())}
//!age.isNullOrEmpty() -> {ages.add(age.toString())}
//!email.isNullOrEmpty() -> {emails.add(email.toString())}

//
