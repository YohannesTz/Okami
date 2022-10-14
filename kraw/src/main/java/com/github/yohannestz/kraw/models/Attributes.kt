package com.github.yohannestz.kraw.models.models

import com.squareup.moshi.Json

@Json(name = "attributes")
data class Attributes(
    val slug: String?,
    val synopsis: String?,
    val titles: Titles,
    val canonicalTitle: String?,
    val averageRating: String?,
    val userCount: Int?,
    val favoritesCount: Int?,
    val startDate: String?,
    val endDate : String?,
    val popularityRank: Int?,
    val ratingRank: Int?,
    val ageRating: String?,
    val ageRatingGuide: String?,
    val subtype: String?,
    val status: String?,
    val tba: String?,
    val posterImage: PosterImage,
    val coverImage: CoverImage,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val youtubeVideoId: String?,
    val showType: String?,
    val nsfw: Boolean?,
    val chapterCount: Int?,
    val volumeCount: Int?,
    val serialization: String?,
    val mangaType: String?
)
