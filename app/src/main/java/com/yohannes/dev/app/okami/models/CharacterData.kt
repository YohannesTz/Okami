package com.yohannes.dev.app.okami.models

import com.google.gson.annotations.SerializedName

data class CharacterData(
    val id: String?,
    val type: String?,
    @SerializedName("attributes")
    val attributes: CharacterAttributes,
)
