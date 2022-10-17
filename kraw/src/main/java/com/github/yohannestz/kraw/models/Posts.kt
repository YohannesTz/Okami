package com.github.yohannestz.kraw.models

data class Posts(
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
    val embed: String?,
    val embedUrl: String?
)
