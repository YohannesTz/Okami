package com.github.yohannestz.kraw.models

import java.io.Serializable

data class Casting(
    val role: String?,
    val voiceActor: Boolean?,
    val featured: Boolean?,
    val language: String?
): Serializable