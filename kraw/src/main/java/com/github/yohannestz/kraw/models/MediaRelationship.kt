package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json
import java.io.Serializable

data class MediaRelationship(
    val role: Role,
): Serializable

data class Role(
    val adaptation: String?,
    @Json(name = "alternative_setting")
    val alternativeSetting: String?,
    @Json(name = "alternative_version")
    val alternativeVersion: String?,
    val character: String?,
    @Json(name = "full_story")
    val fullStory: String?,
    val other: String?,
    @Json(name = "parent_story")
    val parentStory: String?,
    val prequel: String?,
    @Json(name = "side_story")
    val sideStory: String?,
    @Json(name = "spinoff")
    val spinOff: String?,
    val summary: String?
): Serializable