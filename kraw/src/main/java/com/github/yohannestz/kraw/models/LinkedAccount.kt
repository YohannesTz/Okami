package com.github.yohannestz.kraw.models

import com.squareup.moshi.Json
import java.io.Serializable

data class LinkedAccount(
    val kind: String?,
    val externalUserId: String?,
    val token: Token,
    val shareFrom: Boolean?,
    val syncTo: Boolean?,
    val disabledReason: String?
): Serializable

data class Token(
    @Json(name = "resource_owner_id")
    val resourceOwnerId: String?,
    val scopes: List<String>?,
    val application: Application,
    val shareTo: String?,
): Serializable

data class Application(
    val uid: String?
)