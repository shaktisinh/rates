package com.shaktisinh.test.ui.main

import android.util.Log
import androidx.databinding.ObservableArrayList
import com.shaktisinh.test.base.BaseViewModel
import com.shaktisinh.test.data.model.Rate
import com.shaktisinh.test.data.model.ResponseData
import com.shaktisinh.test.data.network.ApiService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.mynameismidori.currencypicker.ExtendedCurrency


/**
 *<h1>MainViewModel</h1>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
class MainViewModel @Inject constructor(private val service: ApiService) : BaseViewModel() {

    private lateinit var dataList: ObservableArrayList<Rate>
    private val compositeDisposable = CompositeDisposable()
    private lateinit var view: MainActivity
    private var updateValue: Boolean = false
    private lateinit var base: String
    /**
     * to initialize the dataList
     */
    fun initData(view: MainActivity, dataList: ObservableArrayList<Rate>) {
        this.view = view
        this.dataList = dataList
        updateValue = true
    }

    fun fetchRates(base: String, value: Double) {
        this.base = base
        service.fetchRates(base).subscribeOn(Schedulers.io())
            .repeatWhen { objectObservable -> objectObservable.delay(1, TimeUnit.SECONDS) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Response<ResponseData>> {
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onNext(response: Response<ResponseData>) {

                    var currency = ExtendedCurrency.getCurrencyByISO(response.body()!!.base)
                    view.setData(
                        Rate(response.body()!!.base, "" + value, currency.name, currency.flag),
                        updateValue
                    )
                    updateValue = false
                    dataList.clear()
                    for (item in response.body()!!.rates) {
                        currency = ExtendedCurrency.getCurrencyByISO(item.key)
                        dataList.add(
                            Rate(
                                item.key,
                                String.format("%.3f", (value * item.value)),
                                currency.name,
                                currency.flag
                            )
                        )
                    }
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {

                }
            })
    }

    public override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        updateValue = false
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.isNotEmpty()) {
            onCleared()
            fetchRates(base, s.toString().toDouble())
        }
    }
}