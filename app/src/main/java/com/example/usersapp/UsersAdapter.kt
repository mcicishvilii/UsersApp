package com.example.usersapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.databinding.UserItemsLayoutBinding
import com.example.usersapp.entities.UsersEntity

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    private val currentList = mutableListOf<UsersEntity>()
    private lateinit var onDeleteClickListener: (UsersEntity) -> Unit
    private lateinit var onEditClickListener: (UsersEntity) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            UserItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindData(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    fun setDeleteClickListener(listener: (UsersEntity) -> Unit) {
        this.onDeleteClickListener = listener
    }

    fun setEditClickListener(listener: (UsersEntity) -> Unit) {
        this.onEditClickListener = listener
    }

    fun updateAll(list: List<UsersEntity>) {
        currentList.clear()
        currentList.addAll(list)
        notifyDataSetChanged()
    }



    inner class UsersViewHolder(private val binding: UserItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(usersEntity: UsersEntity) {

            binding.btnDelete.setOnClickListener {
                onDeleteClickListener.invoke(usersEntity)
            }

            binding.tvFirstname.text = usersEntity.firstName
            binding.tvLastName.text = usersEntity.lastName
            binding.tvEmail.text = usersEntity.email

            binding.btnEdit.setOnClickListener {
                onEditClickListener.invoke(usersEntity)
            }


        }
    }
}