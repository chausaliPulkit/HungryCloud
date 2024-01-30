package com.example.hungrycloud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hungrycloud.databinding.ActivityDetailsFoodBinding

class DetailsFoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemFoodName")
        val foodImage = intent.getIntExtra("MenuItemFoodImage", 0)

        binding.apply {
            detailFoodImageView.setImageResource(foodImage)
            foodNameView.text = foodName

            detailFoodBackButton.setOnClickListener {
                finish()
            }
        }
    }
}