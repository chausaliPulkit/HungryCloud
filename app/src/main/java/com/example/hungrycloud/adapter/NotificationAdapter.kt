package com.example.hungrycloud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hungrycloud.data.NotificationData
import com.example.hungrycloud.databinding.NotificationItemBinding

class NotificationAdapter(private val notificationList: ArrayList<NotificationData>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding =
            NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = notificationList.size

    inner class NotificationViewHolder(private val binding: NotificationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val curNotification = notificationList[position]
            binding.apply {
                notificationTextView.text = curNotification.notification
                notificationImageView.setImageResource(curNotification.notificationImage)
            }
        }

    }

}