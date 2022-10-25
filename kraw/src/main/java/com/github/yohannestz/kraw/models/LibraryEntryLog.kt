package com.github.yohannestz.kraw.models

import java.io.Serializable

data class LibraryEntryLog(
    val progress: Int?,
    val rating: Int?,
    val reconsumeCount: Int?,
    val reconsuming: Int?,
    val status: String?,
    val volumesOwned: Int?,
    val actionPerformed: String?,
    val syncStatus: String?,
    val errorMessage: String?
): Serializable