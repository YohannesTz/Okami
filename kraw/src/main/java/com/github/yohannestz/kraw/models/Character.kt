package com.github.yohannestz.kraw.models

import java.io.Serializable

data class Character(
    val slug: String?,
    val name: String?,
    val malId: Int?,
    val description: String?,
    val image: Image
): Serializable
