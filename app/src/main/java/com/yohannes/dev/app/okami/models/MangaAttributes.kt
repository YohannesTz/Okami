package com.yohannes.dev.app.okami.models

data class MangaAttributes(
    val slug: String?,
    val discription: String?,
    val canonicalTitle: String?,
    val averageRating: String?,
    val status: String?,
    val posterImage: PosterImage?,
    val coverImage: CoverImage?,
    val volumeCount: Int?,
)