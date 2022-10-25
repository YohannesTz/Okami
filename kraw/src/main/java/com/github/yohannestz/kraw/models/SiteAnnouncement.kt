package com.github.yohannestz.kraw.models

import java.io.Serializable

data class SiteAnnouncement(
    val title: String?,
    val description: String?,
    val imageUrl: String?,
    val link: String?
): Serializable