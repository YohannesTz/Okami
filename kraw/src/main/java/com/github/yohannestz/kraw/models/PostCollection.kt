package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json
import java.io.Serializable

/*
data class PostCollection(
    val attributes: List<Post>,
    val includes: List<User>
): Serializable
*/
data class PostCollection(
    @Json(name = "data")
    val data: List<PostChild>,
    @Json(name = "included")
    val included: List<User>
): Serializable

data class PostChild(
    val id: String?,
    @Json(name = "attributes")
    val post: Post
): Serializable
