package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json
import java.io.Serializable

data class Titles(
    @Json(name="ja_jp")
    val jaJp: String?,
    @Json(name="en_us")
    val engUs: String?,
    @Json(name="en_jp")
    val enJp: String?
): Serializable