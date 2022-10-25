package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Image
import java.io.Serializable

data class Category(
    val title: String?,
    val description: String?,
    val totalMediaCount: Int?,
    val slug: String?,
    val nsfw: Boolean?,
    val childCount: Int?,
    val image: Image
): Serializable