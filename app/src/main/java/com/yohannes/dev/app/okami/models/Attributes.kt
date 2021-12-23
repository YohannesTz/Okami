package com.yohannes.dev.app.okami.models

import java.io.Serializable

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
    val userCount: Int?,
    val favoritesCount: Int?,
    val ratingRank: Int?,
    val ageRating: String?,
    val youtubeVideoId: String?,
    val nsfw: Boolean?,
    val volumeCount: Int?,
    val titles: Titles?,
): Serializable