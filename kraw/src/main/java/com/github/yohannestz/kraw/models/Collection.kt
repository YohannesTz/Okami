package com.github.yohannestz.kraw.models

import com.github.yohannestz.kraw.models.Data
import java.io.Serializable

data class Collection(
    val data: List<Data>,
): Serializable
