package com.example.hungrycloud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hungrycloud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavBar.setupWithNavController(navController)
        binding.notificationIconImageView.setOnClickListener {
            val notificationBottomSheetDialog = NotificationBottomFragment()
            notificationBottomSheetDialog.show(supportFragmentManager, "Test")
        }

    }
}