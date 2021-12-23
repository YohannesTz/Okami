package com.yohannes.dev.app.okami.models

import java.io.Serializable

data class Data(
    val id: String?,
    val type: String?,
    val attributes: Attributes
): Serializable
