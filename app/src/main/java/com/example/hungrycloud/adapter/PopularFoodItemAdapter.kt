package com.example.hungrycloud.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungrycloud.DetailsFoodActivity
import com.example.hungrycloud.databinding.PopularItemBinding

class PopularFoodItemAdapter(
    private val items: List<String>,
    private val price: List<Int>,
    private val imageList: List<Int>,
    private val requiredContext: Context
) :
    RecyclerView.Adapter<PopularFoodItemAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val curImage = imageList[position]
        val curItemPrice = price[position]
        holder.bind(item, curImage, curItemPrice)

        holder.itemView.setOnClickListener {
            val intent = Intent(requiredContext, DetailsFoodActivity::class.java)
            intent.putExtra("MenuItemFoodName", item)
            intent.putExtra("MenuItemFoodImage", curImage)
            requiredContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder(private val binding: PopularItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val image = binding.foodImageView
        fun bind(item: String, curImage: Int, curItemPrice: Int) {
            binding.foodName.text = item
            image.setImageResource(curImage)
            binding.priceTextView.text = curItemPrice.toString()
        }


    }
}