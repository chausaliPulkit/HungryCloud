package com.example.hungrycloud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungrycloud.data.MenuItemData
import com.example.hungrycloud.databinding.MenuItemBinding

class MenuAdapter(private val menuItemData: MutableList<MenuItemData>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)

    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemData.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val curMenuItemData = menuItemData[position]
                menuFoodName.text = curMenuItemData.foodName
                menuPriceTextView.text = curMenuItemData.foodPrice
                menuFoodImageView.setImageResource(curMenuItemData.foodImage)
            }
        }

    }
}