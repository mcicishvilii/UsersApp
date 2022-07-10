package com.example.usersapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.usersapp.database.UsersDatabase
import com.example.usersapp.databinding.ChangeUserFragmentBinding
import com.example.usersapp.entities.UsersEntity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class ChangeUserFragment : BottomSheetDialogFragment() {

    private var _binding: ChangeUserFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ChangeUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnChange.setOnClickListener {
            draw()
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

    open fun draw() {

        val updatedUsersEntity = UsersEntity(
            0,
            binding.etFirstName.text.toString(),
            binding.etLastName.text.toString(),
            binding.etEmail.text.toString()
        )

        (requireActivity() as MainActivity).changeUserAndUpdate(updatedUsersEntity)
        dismissAllowingStateLoss()
    }



    companion object {
        const val KEY_CHANGE_FRAGMENT = "KEY_CHANGE_FRAGMENT"
    }
}