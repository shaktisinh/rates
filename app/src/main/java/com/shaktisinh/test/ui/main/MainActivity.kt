package com.shaktisinh.test.ui.main

import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mynameismidori.currencypicker.ExtendedCurrency
import com.shaktisinh.test.base.BaseActivity
import com.shaktisinh.test.data.model.Rate
import com.shaktisinh.test.databinding.ActivityMainBinding
import com.shaktisinh.test.ui.adapter.RateAdapter
import com.shaktisinh.test.util.Constant
import javax.inject.Inject


class MainActivity : BaseActivity(), RateAdapter.ItemClickListner, Constant {


    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var dataList: ObservableArrayList<Rate>
    @Inject
    lateinit var adapter: RateAdapter

    private lateinit var layoutManager: LinearLayoutManager

    /**
     * lazy initialization of ViewModelKey
     */
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, com.shaktisinh.test.R.layout.activity_main)
        binding.viewModel = viewModel

        viewModel.initData(this, dataList)
        viewModel.fetchRates(COUNTRY, 1.0)

        layoutManager = LinearLayoutManager(this)
        binding.rvDataList.layoutManager = layoutManager
        adapter.setItemClickListner(this)
        binding.rvDataList.adapter = adapter
    }

    override fun onItemSelect(position: Int) {
        viewModel.onCleared()
        viewModel.fetchRates(dataList[position].country, 1.0)
    }

    /**
     * set country and value
     */
    fun setData(rate: Rate, updateValue: Boolean) {
        binding.item.tvName.text = rate.country
        binding.item.tvCountryName.text = rate.name
        Glide.with(this).load(rate.flag).apply(RequestOptions.circleCropTransform())
            .into(binding.item.ivFlag)
        if (updateValue)
            binding.item.etValue.setText(rate.value)
    }


}
