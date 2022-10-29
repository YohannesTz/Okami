package com.github.yohannestz.kraw.models

import java.io.Serializable

data class PostCollection(
    val attributes: List<Post>,
    val includes: List<User>
): Serializable