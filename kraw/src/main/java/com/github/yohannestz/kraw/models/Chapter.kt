package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Thumbnail
import com.github.yohannestz.kraw.models.Titles

data class Chapter (
    val titles: Titles,
    val canonicalTitle: String?,
    val volumeNumber: Int?,
    val number: Int?,
    val synopsis: String?,
    val published: String?,
    val length: String?,
    val thumbnail: Thumbnail
)