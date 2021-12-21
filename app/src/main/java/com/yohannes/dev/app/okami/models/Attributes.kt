package com.yohannes.dev.app.okami.models

data class Attributes(
    val slug: String?,
    val description: String?,
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
    val nsfw: Boolean?,
    val volumeCount: Int?,
    val titles: Titles?,
)