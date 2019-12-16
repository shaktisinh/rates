package com.shaktisinh.test.di.module


import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * <h1>AppUtilModule</h1>
 *
 * @author Shaktisinh Jadeja
 * @since 15 Dec 2019
 */
@Module
class AppUtilModule {
    internal val gson: Gson
        @Provides
        @Singleton
        get() = Gson()
}
