package com.example.hungrycloud.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungrycloud.PayoutActivity
import com.example.hungrycloud.R
import com.example.hungrycloud.adapter.CartAdapter
import com.example.hungrycloud.data.CartItemData
import com.example.hungrycloud.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
//        dummy Data
        val carItemList = listOf<CartItemData>(
            CartItemData("Burger", "₹50", R.drawable.burger),
            CartItemData("Momos", "₹40", R.drawable.momos),
            CartItemData("Sandwich", "₹70", R.drawable.sandwich),
            CartItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
        )
        val adapter = CartAdapter(ArrayList(carItemList))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter

//        setting clicklistener on proceed button to open payout activity
        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(), PayoutActivity::class.java);
            startActivity(intent)
        }
        return binding.root
    }

    companion object {
    }
}