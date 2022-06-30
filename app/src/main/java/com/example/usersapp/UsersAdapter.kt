package com.example.usersapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.databinding.UserItemsLayoutBinding
import com.example.usersapp.entities.UsersEntity

class UsersAdapter(var userList: MutableList<UsersEntity>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    private lateinit var onDeleteClickListener: (UsersEntity) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            UserItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindData(userList[position])

    }

    fun setData(user: MutableList<UsersEntity>){
        this.userList = user
        notifyDataSetChanged()
    }

    fun setDeleteClickListener(listener: (UsersEntity) -> Unit) {
        this.onDeleteClickListener = listener
    }



    override fun getItemCount(): Int {
        return userList.size

    }

    inner class UsersViewHolder(val binding: UserItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(usersEntity: UsersEntity) {
            binding.tvFirstname.text = usersEntity.firstName
            binding.tvLastName.text = usersEntity.lastName

            binding.tvFirstname.setOnClickListener {
                onDeleteClickListener.invoke(usersEntity)
            }
        }

    }
}