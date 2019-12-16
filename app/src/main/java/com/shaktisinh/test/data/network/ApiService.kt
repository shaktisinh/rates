package com.shaktisinh.test.data.network

import androidx.databinding.ObservableArrayList
import com.shaktisinh.test.data.model.ResponseData
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 *<h1>ApiService</h1>
 *
 *<p>contains all apis </p>
 *
 * @author : Shaktisinh Jadeja
 * @since : 15 Dec 2019
 */
interface ApiService {
    @GET("latest")
    fun fetchRates(@Query("base") base: String): Observable<Response<ResponseData>>
}