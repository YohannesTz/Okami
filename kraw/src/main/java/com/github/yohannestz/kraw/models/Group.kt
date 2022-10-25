package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Image
import java.io.Serializable

data class Group(
    val slug: String?,
    val about: String?,
    val locale: String?,
    val membersCount: Int?,
    val name: String?,
    val nsfw: Boolean?,
    val privacy: String?,
    val rules: String?,
    val rulesFormatted: String?,
    val leadersCount: Int?,
    val neighborsCount: Int?,
    val featured: Boolean?,
    val tagLine: String?,
    val lastActivityAt: String?,
    val avatar: Avatar?,
    val coverImage: Image
): Serializable