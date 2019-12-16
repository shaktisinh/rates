package com.shaktisinh.test.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shaktisinh.test.di.annotation.ViewModelKey
import com.shaktisinh.test.di.factory.ViewModelFactory
import com.shaktisinh.test.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *<h1>ViewModelModule</h1>
 *
 *<p>it binds the viewmodel</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 10 Dec 2019
 */
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

}