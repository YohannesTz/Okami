package com.github.yohannestz.kraw.models

data class TokenRequestBody(
    val grant_type: String,
    val username: String,
    val password: String
)
