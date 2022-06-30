package com.example.usersapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.databinding.ActivityMainBinding
import com.example.usersapp.fragments.AddUserFragment

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent, DashboardFragment())
            addToBackStack(DashboardFragment::javaClass.name)
            commit()
        }
    }
}



