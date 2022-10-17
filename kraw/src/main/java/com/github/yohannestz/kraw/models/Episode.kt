package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json

data class Episode(
    val titles: Titles?,
    val canonicalTitle: String?,
    val seasonNumber: Int?,
    val number:Int?,
    val relativeNumber: Int?,
    val synopsis: String?,
    @Json(name="airdate")
    val airDate: String?,
    val length: String?,
    val thumbnail: Thumbnail?
)
