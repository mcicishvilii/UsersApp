package com.example.usersapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.databinding.UserItemsLayoutBinding
import com.example.usersapp.entities.UsersEntity

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){
    private val currentList = mutableListOf<UsersEntity>()


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







    inner class UsersViewHolder(private val binding: UserItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(usersEntity: UsersEntity) {
            binding.tvFirstname.text = usersEntity.firstName

        }
    }
}