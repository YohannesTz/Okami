package com.github.yohannestz.kraw.models.models

import com.squareup.moshi.Json

data class LinkedAccount(
    val kind: String?,
    val externalUserId: String?,
    val token: Token,
    val shareFrom: Boolean?,
    val syncTo: Boolean?,
    val disabledReason: String?
)

data class Token(
    @Json(name = "resource_owner_id")
    val resourceOwnerId: String?,
    val scopes: List<String>?,
    val application: Application,
    val shareTo: String?,
)

data class Application(
    val uid: String?
)