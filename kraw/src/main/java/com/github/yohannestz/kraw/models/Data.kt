package com.github.yohannestz.kraw.models.models

import java.io.Serializable

data class Data(
    val id: String?,
    val type: String?,
    val attributes: Attributes
): Serializable
