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
    val included: List<UserChild>
): Serializable

data class PostChild(
    val id: String?,
    val type: String?,
    @Json(name = "attributes")
    val attributes: Post?
): Serializable

data class UserChild(
    val id: String?,
    val type: String?,
    @Json(name = "attributes")
    val attributes: User?
)
