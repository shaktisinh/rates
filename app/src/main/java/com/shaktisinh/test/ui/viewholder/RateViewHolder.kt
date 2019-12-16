package com.shaktisinh.test.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.shaktisinh.test.data.model.Rate
import com.shaktisinh.test.databinding.ItemRateBinding

class RateViewHolder constructor(val binding: ItemRateBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Rate) {
        binding.data = data
    }
}
