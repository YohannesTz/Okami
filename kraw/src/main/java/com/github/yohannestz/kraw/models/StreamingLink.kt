package com.github.yohannestz.kraw.models

import java.io.Serializable

data class StreamingLink(
    val url: String?,
    val subs: List<String>?,
    val dubs: List<String>?
): Serializable
