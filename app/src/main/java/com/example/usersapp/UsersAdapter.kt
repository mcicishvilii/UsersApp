package com.example.usersapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.databinding.UserItemsLayoutBinding
import com.example.usersapp.entities.UsersEntity

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewholder>() {

    private val currentList = mutableListOf<UsersEntity>()
    private lateinit var onDeleteClickListener: (UsersEntity) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewholder {
        val binding =
            UserItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewholder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewholder, position: Int) {
        holder.bindData(currentList[position])
    }

    fun setDeleteClickListener(listener: (UsersEntity) -> Unit) {
        this.onDeleteClickListener = listener
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    fun updateAll(list: List<UsersEntity>) {
        currentList.clear()
        currentList.addAll(list)
        notifyDataSetChanged()
    }

    inner class UsersViewholder(private val binding: UserItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(usersEntity: UsersEntity) {
            binding.tvFirstname.text = usersEntity.firstName
            binding.tvLastName.text = usersEntity.lastName

            binding.delButton.setOnClickListener {
                onDeleteClickListener.invoke(usersEntity)
            }
        }
    }

}