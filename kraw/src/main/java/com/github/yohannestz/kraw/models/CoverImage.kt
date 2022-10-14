package com.github.yohannestz.kraw.models.models

import java.io.Serializable

data class CoverImage(
    val tiny: String?,
    val large: String?,
    val small: String?,
    val original: String?,
): Serializable
