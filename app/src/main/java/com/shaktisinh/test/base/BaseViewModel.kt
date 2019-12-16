package com.shaktisinh.test.base

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * <h1>BaseViewModel</h1>
 *
 *
 * Includes all base functionality of ViewModelKey which you can override to your ViewModelKey class
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
open class BaseViewModel : ViewModel(), Observable {

    private val mDisposable = CompositeDisposable()
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    /**
     * adds Disposable
     */
    protected fun Disposable.track() {
        mDisposable.add(this)
    }

    /**
     * clears Disposable
     */
    override fun onCleared() {
        mDisposable.clear()
        super.onCleared()
    }

}
