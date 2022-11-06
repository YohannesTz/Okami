package com.github.yohannestz.kraw.models

data class TokenResponse(
    val access_token: String?,
    val token_type: String?,
    val expires_in: String?,
    val refresh_token: String?,
    val scope: String?,
    val created_at: String?
)
