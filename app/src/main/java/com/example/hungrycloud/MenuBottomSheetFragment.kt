package com.example.hungrycloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungrycloud.adapter.MenuAdapter
import com.example.hungrycloud.data.MenuItemData
import com.example.hungrycloud.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.menuBottomSheetBackButton.setOnClickListener {
            dismiss()
        }

        val menuFoodList = listOf<MenuItemData>(
            MenuItemData("Burger", "₹50", R.drawable.burger),
            MenuItemData("Momos", "₹40", R.drawable.momos),
            MenuItemData("Sandwich", "₹70", R.drawable.sandwich),
            MenuItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
            MenuItemData("Burger", "₹50", R.drawable.burger),
            MenuItemData("Momos", "₹40", R.drawable.momos),
            MenuItemData("Sandwich", "₹70", R.drawable.sandwich),
            MenuItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
        )
        val adapter = MenuAdapter(menuFoodList as MutableList<MenuItemData>, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {
    }
}