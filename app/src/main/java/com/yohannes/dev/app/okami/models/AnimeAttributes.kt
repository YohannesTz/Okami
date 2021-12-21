package com.yohannes.dev.app.okami.models

data class AnimeAttributes(
    val slug: String?,
    val discription: String?,
    val canonicalTitle: String?,
    val averageRating: String?,
    val startDate: String?,
    val endDate: String?,
    val ageRatingGuide: String?,
    val status: String?,
    val posterImage: PosterImage?,
    val coverImage: CoverImage?,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val totalLength: Int?,
    val youtubeVideoId: String?,
    val nsfw: Boolean
)
