package com.yohannes.dev.app.okami.models

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("data")
    val data: List<CharacterData>,
)
