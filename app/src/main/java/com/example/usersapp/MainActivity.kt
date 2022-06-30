package com.example.usersapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.databinding.ActivityMainBinding
import com.example.usersapp.entities.UsersEntity
import com.example.usersapp.fragments.AddUserFragment
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var database: UsersDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Fresco.initialize(this)
        setContentView(binding.root)


        binding.btnAddUser.setOnClickListener {
            AddUserFragment().show(supportFragmentManager, AddUserFragment.KEY_ADD_FRAGMENT)
        }

        usersAdapter = UsersAdapter().apply {
            setDeleteClickListener {
                database.usersDao().deleteUser(it)
                drawUserItems()
            }
        }

        binding.rvUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvUsers.adapter = usersAdapter

        database = UsersDatabase.getDatabase(applicationContext)
        drawUserItems()
    }

    fun insertAndUpdateRv(usersEntity: UsersEntity) {
        database.usersDao().addUser(usersEntity)
        drawUserItems()
    }

    private fun drawUserItems() {
        val allBooks = database.usersDao().getAll()
        usersAdapter.updateAll(allBooks)
    }
}



