package com.example.usersapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.usersapp.databinding.AddUserFragmentBinding
import com.example.usersapp.entities.UsersEntity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class UsersFragment : BottomSheetDialogFragment() {
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


        binding.btnSave.setOnClickListener {

            val usersEntity = UsersEntity(
                0,
                binding.etFirstName.text.toString() + "cicisha",
                binding.etLastName.text.toString(),
                binding.etEmail.text.toString()
            )

            (requireActivity() as MainActivity).insertAndUpdateRv(usersEntity)
            dismissAllowingStateLoss()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

    companion object {
        const val KEY_ADD_FRAGMENT = "KEY_ADD_FRAGMENT"
    }
}