package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Image

data class Category(
    val title: String?,
    val description: String?,
    val totalMediaCount: Int?,
    val slug: String?,
    val nsfw: Boolean?,
    val childCount: Int?,
    val image: Image
)