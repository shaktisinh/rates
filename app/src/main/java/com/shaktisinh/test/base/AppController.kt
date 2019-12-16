package com.shaktisinh.test.base

import android.content.Context

import androidx.multidex.MultiDex

import com.shaktisinh.test.di.component.AppComponent
import com.shaktisinh.test.di.component.DaggerAppComponent
import com.shaktisinh.test.di.module.AppUtilModule
import com.shaktisinh.test.di.module.NetworkModule

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * <h1>AppController</h1>
 *
 * <p>Application class</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
class AppController : DaggerApplication() {
    var appComponent: AppComponent? = null
        private set

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .appUtilModule(AppUtilModule())
            .build()
        appComponent!!.inject(this)
        return appComponent as AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }

    companion object {
        @get:Synchronized
        var instance: AppController? = null
            private set
    }
}
