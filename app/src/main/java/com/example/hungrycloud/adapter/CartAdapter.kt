package com.example.hungrycloud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungrycloud.data.CartItemData
import com.example.hungrycloud.databinding.CartItemBinding

class CartAdapter(
    private val cartItemData: MutableList<CartItemData>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantities = IntArray(cartItemData.size)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItemData.size


    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val curCartItemData = cartItemData[position]
            val quantity = itemQuantities[position]
            binding.apply {
                cartFoodName.text = curCartItemData.cartItemName
                cartItemPrice.text = curCartItemData.cartItemPrice
                cartFoodImage.setImageResource(curCartItemData.cartItemImage)
                foodQuantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    decreaseQuantity(position)

                }
                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(position)
                    }
                }

            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.foodQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.foodQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun deleteItem(position: Int) {
            cartItemData.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItemData.size)
        }
    }
}
