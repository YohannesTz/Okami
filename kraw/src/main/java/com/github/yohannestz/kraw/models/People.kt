package com.github.yohannestz.kraw.models

import java.io.Serializable

data class People(
    val image: String?,
    val name: String?,
    val malId: Int?
): Serializable
