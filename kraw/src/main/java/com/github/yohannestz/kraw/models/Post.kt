package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json
import java.io.Serializable

@Json(name = "attributes")
data class Post(
    val createdAt: String?,
    val updatedAt: String?,
    val content: String?,
    val contentFormatted: String?,
    val commentsCount: Int?,
    val postLikesCount: Int?,
    val nsfw: Boolean?,
    val blocked: Boolean?,
    val deletedAt: String?,
    val topLevelCommentsCount: Int?,
    val editedAt: String?,
    val targetInterest: String?,
    val embed: Embed?,
    val embedUrl: String?
): Serializable

data class Embed (
    val url: String?,
    val kind: String?,
    val image: Image?,
    val title: String?
): Serializable
