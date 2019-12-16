package com.shaktisinh.test.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Rate(
    @SerializedName("country") var country: String,
    @SerializedName("value") var value: String,
    @SerializedName("name") var name: String,
    @SerializedName("flag") var flag: Int
) : Serializable