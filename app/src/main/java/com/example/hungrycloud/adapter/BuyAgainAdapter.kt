package com.example.hungrycloud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungrycloud.data.MenuItemData
import com.example.hungrycloud.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val foodItemList: ArrayList<MenuItemData>) :
    RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding =
            BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = foodItemList.size


    inner class BuyAgainViewHolder(private val binding: BuyAgainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val curMenuItemData = foodItemList[position]
            binding.apply {
                recentBuyFoodnameTextview.text = curMenuItemData.foodName
                recentBuyFoodpriceTextview.text = curMenuItemData.foodPrice
                recentBuyFoodimageTextview.setImageResource(curMenuItemData.foodImage)
            }
        }

    }
}