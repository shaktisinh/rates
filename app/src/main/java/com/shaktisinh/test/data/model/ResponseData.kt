package com.shaktisinh.test.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseData(
    @SerializedName("base") var base: String,
    @SerializedName("date") var date: String,
    @SerializedName("rates") var rates: Map<String, Double>
) : Serializable