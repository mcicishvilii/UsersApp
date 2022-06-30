package com.example.usersapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.databinding.DashboardActivityBinding
import com.example.usersapp.entities.UsersEntity
import com.example.usersapp.fragments.AddUserFragment

class DashboardFragment: Fragment() {

    private val viewModel by viewModels<UserViewModel>()
    private lateinit var usersAdapter: UsersAdapter
    private var _binding: DashboardActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DashboardActivityBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            usersAdapter.setData(user as MutableList<UsersEntity>)
        })

        usersAdapter.setDeleteClickListener {
            val user = UsersEntity()
            viewModel.removeUser()
        }


        usersAdapter = UsersAdapter(mutableListOf()).apply {
            binding.btnAddUser.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent, AddUserFragment())
                    addToBackStack(AddUserFragment::javaClass.name)
                    commit()
                }
            }
        }



        binding.rvUsers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvUsers.adapter = usersAdapter


    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}