package com.shaktisinh.test.di.component

import android.app.Application
import com.repso.di.module.AppModule
import com.shaktisinh.test.base.AppController
import com.shaktisinh.test.di.module.ActivityBindModule
import com.shaktisinh.test.di.module.AppUtilModule
import com.shaktisinh.test.di.module.NetworkModule
import com.shaktisinh.test.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule

/**
 *<h1>AppComponent</h1>
 *
 *<p>builds all app level modules and provides it</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */

@Singleton
@Component(modules = [ViewModelModule::class, AppModule::class, AppUtilModule::class, NetworkModule::class, ActivityBindModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(appController: AppController)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        @BindsInstance
        fun networkModule(networkModule: NetworkModule): AppComponent.Builder

        @BindsInstance
        fun appUtilModule(appUtilModule: AppUtilModule): AppComponent.Builder

        fun build(): AppComponent
    }
}