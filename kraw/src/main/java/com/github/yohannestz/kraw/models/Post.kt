package com.github.yohannestz.kraw.models

import java.io.Serializable

data class Post(
    val content: String?,
    val contentFormatted: String?,
    val commentsCount: Int?,
    val postLikesCount: Int?,
    val nsfw: Boolean?,
    val blocked: Boolean?,
    val deletedAt: String?,
    val createdAt: String?,
    val topLevelCommentsCount: Int?,
    val editedAt: String?,
    val targetInterest: String?,
    val embed: String?,
    val embedUrl: String?
): Serializable
