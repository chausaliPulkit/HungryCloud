package com.example.hungrycloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungrycloud.adapter.NotificationAdapter
import com.example.hungrycloud.data.NotificationData
import com.example.hungrycloud.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding
    private lateinit var notificationAdapter: NotificationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)
        val notificationList = listOf(
            NotificationData("Your order has been canceled Successfully", R.drawable.sadcloudemoji),
            NotificationData("Order has been taken by driver", R.drawable.carcloudimage),
            NotificationData("Congrats your order has been placed ", R.drawable.checkmarksign)
        )
        notificationAdapter = NotificationAdapter(ArrayList(notificationList))
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = notificationAdapter

        return binding.root
    }

    companion object {
    }
}