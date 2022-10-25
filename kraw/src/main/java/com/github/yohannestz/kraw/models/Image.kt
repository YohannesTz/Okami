package com.github.yohannestz.kraw.models

import java.io.Serializable

data class Image(
    val tiny: String?,
    val small: String?,
    val medium: String?,
    val large: String?,
    val original: String?
): Serializable