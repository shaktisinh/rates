package com.shaktisinh.test.ui.main

import android.content.Context
import androidx.databinding.ObservableArrayList
import com.shaktisinh.test.data.model.Rate
import com.shaktisinh.test.di.annotation.ActivityScope
import com.shaktisinh.test.ui.adapter.RateAdapter
import dagger.Module
import dagger.Provides

/**
 *<h1>MainUtilModule</h1>
 *
 *<p>Contains all utilities for MainActivity</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
@Module
class MainUtilModule {

    @ActivityScope
    @Provides
    fun provideObservableArrayList(): ObservableArrayList<Rate> {
        return ObservableArrayList();
    }

    @ActivityScope
    @Provides
    fun provideRateAdapter(context: Context, items: ObservableArrayList<Rate>): RateAdapter {
        return RateAdapter(context, items)
    }
}