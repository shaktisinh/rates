package com.repso.di.module


import android.app.Application
import android.content.Context

import dagger.Binds
import dagger.Module

/**
 * <h1>AppModule</h1>
 *
 * @author Shaktisinh Jadeja
 * @since 15 Dec 2019
 */
@Module
interface AppModule {
    @Binds
    fun bindContext(application: Application): Context
}
