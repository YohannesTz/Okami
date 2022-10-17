package com.github.yohannestz.kraw.models

data class Character(
    val slug: String?,
    val name: String?,
    val malId: Int?,
    val description: String?,
    val image: Image
)
