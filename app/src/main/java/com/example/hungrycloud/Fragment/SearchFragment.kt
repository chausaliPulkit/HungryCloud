package com.example.hungrycloud.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungrycloud.R
import com.example.hungrycloud.adapter.MenuAdapter
import com.example.hungrycloud.data.MenuItemData
import com.example.hungrycloud.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val menuFoodList = listOf<MenuItemData>(
        MenuItemData("Burger", "₹50", R.drawable.burger),
        MenuItemData("Momos", "₹40", R.drawable.momos),
        MenuItemData("Sandwich", "₹70", R.drawable.sandwich),
        MenuItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
        MenuItemData("Burger", "₹50", R.drawable.burger),
        MenuItemData("Momos", "₹40", R.drawable.momos),
        MenuItemData("Sandwich", "₹70", R.drawable.sandwich),
        MenuItemData("Kathi Roll", "₹60", R.drawable.kathirolls),
    )
    private val filteredMenuFoodList = mutableListOf<MenuItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuFoodList, requireContext())
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.searchRecyclerView.adapter = adapter

//        setup search View
        searchTheFood()
//        show all menu Item
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodList.clear()
        filteredMenuFoodList.addAll(
            menuFoodList
        )
        adapter.notifyDataSetChanged()
    }

    private fun searchTheFood() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            //        anonymous object implementing interface
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    filterMenuItems(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filterMenuItems(newText)
                }
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodList.clear()

        menuFoodList.forEachIndexed { index, foodList ->
            if (foodList.foodName.contains(query, ignoreCase = true)) {
//       Params: ignoreCase - true to ignore character case when comparing characters. By default false.
                filteredMenuFoodList.add(
                    MenuItemData(
                        foodList.foodName,
                        foodList.foodPrice,
                        foodList.foodImage
                    )
                )
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {
    }
}
