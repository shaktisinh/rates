package com.shaktisinh.test.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.shaktisinh.test.R
import com.shaktisinh.test.data.model.Rate
import com.shaktisinh.test.databinding.ItemRateBinding
import com.shaktisinh.test.ui.viewholder.RateViewHolder

/**
 * <h1>RateAdapter</h1>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
class RateAdapter constructor(
    private val context: Context,
    private val items: ObservableArrayList<Rate>
) :
    ObservableRecyclerViewAdapter<Rate, RateViewHolder>(items) {

    private lateinit var itemClickListner: ItemClickListner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val binding = DataBindingUtil.inflate<ItemRateBinding>(
            LayoutInflater.from(parent.context), R.layout.item_rate, parent, false
        )
        return RateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.ivFlag.setImageResource(items[position].flag)
        Glide.with(context).load(items[position].flag).apply(RequestOptions.circleCropTransform()).into(holder.binding.ivFlag)
        holder.binding.root.setOnClickListener { itemClickListner.onItemSelect(position) }
    }

    fun setItemClickListner(itemClickListner: ItemClickListner) {
        this.itemClickListner = itemClickListner
    }

    interface ItemClickListner {
        fun onItemSelect(position: Int)
    }

}
