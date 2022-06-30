package com.example.usersapp.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.usersapp.DashboardFragment
import com.example.usersapp.R
import com.example.usersapp.UserViewModel
import com.example.usersapp.databinding.AddUserFragmentBinding
import com.example.usersapp.entities.UsersEntity


class AddUserFragment : Fragment() {
    private val viewModel by viewModels<UserViewModel>()
    private var _binding: AddUserFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnAddUser.setOnClickListener{
            insertDataToDB()
        }

    }

    private fun insertDataToDB() {
        val firstname = binding.etFirstName.text.toString()
        val lastname = binding.etLastName.text.toString()
        val age = binding.etAge.text.toString()
        val email = binding.etEmail.text.toString()

        if(inputCheck(firstname,lastname,age,email)){
            val user = UsersEntity(0,firstname,lastname,age,email)
            viewModel.addUser(user)

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flContent, DashboardFragment())
                addToBackStack(DashboardFragment::javaClass.name)
                commit()
            }
        }
    }

    private fun inputCheck(firstname:String, lastname:String, age:String, email:String, ):Boolean{
        return !(TextUtils.isEmpty(firstname) &&
                TextUtils.isEmpty(lastname) &&
                TextUtils.isEmpty(age) &&
                TextUtils.isEmpty(email))
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }
}