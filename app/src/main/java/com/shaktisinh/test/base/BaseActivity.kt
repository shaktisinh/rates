package com.shaktisinh.test.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 *<h1>BaseActivity</h1>
 *
 *<p>Includes all base functionality which you can override to your activity</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    /**
     * Use this method to initialize view components.
     */
    open fun initView() {
    }

}