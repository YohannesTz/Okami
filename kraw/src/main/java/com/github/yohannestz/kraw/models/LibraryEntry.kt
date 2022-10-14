package com.github.yohannestz.kraw.models.models

data class LibraryEntry(
    val status: String?,
    val progress: Int?,
    val volumesOwned: Int?,
    val reconsuming: Boolean?,
    val reconsumeCount: Int?,
    val notes: String?,
    val private: Boolean?,
    val reactionSkipped: String?,
    val progressedAt: String?,
    val startedAt: String?,
    val finishedAt: String?,
    val rating: String?,
    val ratingTwenty: Int?
)