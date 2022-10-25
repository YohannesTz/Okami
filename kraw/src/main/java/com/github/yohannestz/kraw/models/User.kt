package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Avatar
import com.squareup.moshi.Json
import java.io.Serializable

data class User(
    val name: String?,
    val slug: String?,
    val about: String?,
    val location: String?,
    val waifuOrHusbando: String?,
    val followersCount: Int?,
    val followingCount: Int?,
    @Deprecated("Deprecated, use the stats relationship")
    val lifeSpentOnAnime: Int?,
    val birthday: String?,
    val commentsCount: Int?,
    val favoritesCount: Int?,
    val likesGivenCount: Int?,
    val reviewsCount: Int?,
    val likesReceivedCount: Int?,
    val postsCount: Int?,
    val ratingsCount: Int?,
    val mediaReactionsCount: Int?,
    val proExpiresAt: String?,
    val title: String?,
    val profileCompleted: Boolean?,
    val feedCompleted: Boolean?,
    val website: String?,
    val proTier: String?,
    val avatar: Avatar?,
    val coverImage: CoverImage?,
    val email: String?,
    val password: String?,
    val confirmed: String?,
    val previousEmail: String?,
    val language: String?,
    val country: String?,
    val shareToGlobal: Boolean?,
    @Json(name = "titleLanguagePreferencecanonical")
    val titleLanguagePreferenceCanonical: String,
    val sfwFilter: Boolean?,
    val ratingSystem: String?,
    val theme: String?,
    val facebookId: String?,
    val hasPassword: Boolean?,
    val status: String?,
    val subscribedToNewsletter: Boolean?,
    val aoPro: String?,
): Serializable