package com.github.yohannestz.kraw.models.models
@Deprecated("Use media-reactions instead.")
data class Review(
    val content: String?,
    val contentFormatted: String?,
    val likesCount: Int?,
    val progress: String?,
    val rating: Int?,
    val source: String?,
    val spoiler: Boolean
)
