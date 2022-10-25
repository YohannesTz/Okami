package com.github.yohannestz.kraw.models

import java.io.Serializable

data class Comment(
    val content: String?,
    val contentFormatted: String?,
    val blocked: Boolean?,
    val deletedAt: String?,
    val likesCount: Int?,
    val repliesCount: Int?,
    val editedAt: String?,
    val embed: String?,
    val embedUrl: String?
): Serializable
