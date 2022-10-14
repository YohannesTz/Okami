package com.github.yohannestz.kraw.models.models

import java.io.Serializable

data class PosterImage(
    val tiny: String?,
    val large: String?,
    val small: String?,
    val medium: String?,
    val original: String?,
): Serializable
