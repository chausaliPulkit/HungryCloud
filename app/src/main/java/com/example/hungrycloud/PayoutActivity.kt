package com.example.hungrycloud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hungrycloud.databinding.ActivityPayoutBinding

class PayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setting click listener for placeMyOrderButton to move to congratsBottomSheet
        binding.placeMyOrderButton.setOnClickListener {
            val bottomSheetDialogFragment = CongratsBottomSheet()
            bottomSheetDialogFragment.show(supportFragmentManager, "Test")
        }
//        setting click listener on back button to move back to previous activity
        binding.payoutActivityBackButton.setOnClickListener {
            finish()
        }
    }
}