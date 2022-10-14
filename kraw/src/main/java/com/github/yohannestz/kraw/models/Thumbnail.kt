package com.github.yohannestz.kraw.models.models

import com.squareup.moshi.Json

@Json(name="thumbnail")
data class Thumbnail (
    val original: String?,
)