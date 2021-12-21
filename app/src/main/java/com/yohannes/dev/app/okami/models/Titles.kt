package com.yohannes.dev.app.okami.models

import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("ja_jp")
    val jaJp: String?,
    @SerializedName("en_us")
    val engUs: String?,
    @SerializedName("en_jp")
    val enJp: String?
)
