package com.github.yohannestz.kraw.models

import java.io.Serializable

data class Streamer(
    val siteName: String?,
    val streamingLinksCount: String?,
    val logo: String?
): Serializable
