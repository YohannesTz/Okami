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
    val scopes: Array<String>?,
    val application: Application,
    val shareTo: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Token

        if (resourceOwnerId != other.resourceOwnerId) return false
        if (scopes != null) {
            if (other.scopes == null) return false
            if (!scopes.contentEquals(other.scopes)) return false
        } else if (other.scopes != null) return false
        if (application != other.application) return false
        if (shareTo != other.shareTo) return false
        return true
    }

    override fun hashCode(): Int {
        var result = resourceOwnerId?.hashCode() ?: 0
        result = 31 * result + (scopes?.contentHashCode() ?: 0)
        result = 31 * result + application.hashCode()
        result = 31 * result + (shareTo?.hashCode() ?: 0)
        return result
    }
}

data class Application(
    val uid: String?
)