package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json
import java.io.Serializable

@Json(name="thumbnail")
data class Thumbnail (
    val original: String?,
): Serializable