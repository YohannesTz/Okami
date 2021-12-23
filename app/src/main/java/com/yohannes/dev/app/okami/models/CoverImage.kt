package com.yohannes.dev.app.okami.models

import java.io.Serializable

data class CoverImage(
    val tiny: String?,
    val large: String?,
    val small: String?,
    val original: String?,
): Serializable
