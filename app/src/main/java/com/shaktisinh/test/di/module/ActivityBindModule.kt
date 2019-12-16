package com.shaktisinh.test.di.module

import com.shaktisinh.test.di.annotation.ActivityScope
import com.shaktisinh.test.ui.main.MainActivity
import com.shaktisinh.test.ui.main.MainUtilModule
import com.shaktisinh.test.ui.main.MainViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *<h1>ActivityBindModule</h1>
 *
 *<p>it binds the activities</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
@Module
interface ActivityBindModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainUtilModule::class])
    fun mainActivity(): MainActivity
}