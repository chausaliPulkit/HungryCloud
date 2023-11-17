package com.example.hungrycloud.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungrycloud.R
import com.example.hungrycloud.adapter.BuyAgainAdapter
import com.example.hungrycloud.data.MenuItemData
import com.example.hungrycloud.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val menuFoodList = arrayListOf<MenuItemData>(
            MenuItemData("Burger", "₹50", R.drawable.burger),
            MenuItemData("Momos", "₹40", R.drawable.momos),
            MenuItemData("Sandwich", "₹70", R.drawable.sandwich),
            MenuItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
            MenuItemData("Burger", "₹50", R.drawable.burger),
            MenuItemData("Momos", "₹40", R.drawable.momos),
            MenuItemData("Sandwich", "₹70", R.drawable.sandwich),
            MenuItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
        )
        buyAgainAdapter = BuyAgainAdapter(menuFoodList)
        binding.recentBuyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recentBuyRecyclerView.adapter = buyAgainAdapter
    }

    companion object {
    }
}