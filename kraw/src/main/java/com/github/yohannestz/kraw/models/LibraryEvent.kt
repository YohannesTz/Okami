package com.github.yohannestz.kraw.models

data class LibraryEvent(
    val notes: String?,
    val nsfw: Boolean?,
    val private: Boolean?,
    val progress: Int?,
    val rating: Int?,
    val reconsuming: Boolean?,
    val reconsumeCount: Int?,
    val volumesOwned: Int?,
    val timeSpent: Int?,
    val status: String?,
    val event: String?,
    //val changedData: -> not enough info was provided
)