package com.example.hungrycloud.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hungrycloud.R
import com.example.hungrycloud.adapter.PopularFoodItemAdapter
import com.example.hungrycloud.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.kathirolls, scaleType = ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.kathirolls, scaleType = ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.kathirolls, scaleType = ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, scaleType = ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position "
                Toast.makeText(context, itemMessage, Toast.LENGTH_SHORT).show()
            }

        })
        val foodName = listOf("Burger", "Momos", "Sandwich", "Rolls")
        val price = listOf(5, 10, 15, 2)
        val foodImages = listOf(
            R.drawable.burger,
            R.drawable.momos,
            R.drawable.sandwich,
            R.drawable.kathirolls
        )
        val adapter = PopularFoodItemAdapter(foodName, price, foodImages)
        binding.foodItemRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.foodItemRecyclerView.adapter = adapter
    }


    companion object {}
}