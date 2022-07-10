package com.example.usersapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.databinding.ActivityMainBinding
import com.example.usersapp.databinding.UserItemsLayoutBinding
import com.example.usersapp.entities.UsersEntity


class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var database: UsersDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)





        usersAdapter = UsersAdapter().apply {
            setDeleteClickListener {
                database.usersDao().deleteUser(it)
                drawUsers()
            }

            setEditClickListener {
                ChangeUserFragment().show(supportFragmentManager, ChangeUserFragment.KEY_CHANGE_FRAGMENT)
            }
        }


        b.btnAddUser.setOnClickListener {
            UsersFragment().show(supportFragmentManager, UsersFragment.KEY_ADD_FRAGMENT)
        }



        b.rvUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        b.rvUsers.adapter = usersAdapter

        database = UsersDatabase.getDatabase(applicationContext)
        drawUsers()
    }

    private fun drawUsers() {
        val allUsers = database.usersDao().getAll()
        usersAdapter.updateAll(allUsers)

    }

     fun insertAndUpdateRv(usersEntity: UsersEntity) {
        database.usersDao().insertUser(usersEntity)
        drawUsers()
    }

    fun changeUserAndUpdate(usersEntity: UsersEntity) {
        database.usersDao().updateUser(usersEntity)
        drawUsers()
    }

}