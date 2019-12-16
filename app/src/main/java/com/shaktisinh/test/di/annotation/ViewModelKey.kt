package com.shaktisinh.test.di.annotation

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 *<h1>ViewModelKey</h1>
 *
 *<p>ViewModelKey annotation</p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)