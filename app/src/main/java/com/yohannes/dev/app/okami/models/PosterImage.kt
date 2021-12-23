package com.yohannes.dev.app.okami.models

import java.io.Serializable

data class PosterImage(
    val tiny: String?,
    val large: String?,
    val small: String?,
    val medium: String?,
    val original: String?,
): Serializable
