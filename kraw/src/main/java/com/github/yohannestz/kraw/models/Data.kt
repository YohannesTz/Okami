package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Attributes
import java.io.Serializable

data class Data(
    val id: String?,
    val type: String?,
    val attributes: Attributes
): Serializable
