package com.github.yohannestz.kraw.models.models

data class ListImport(
    val kind: String?,
    val inputText: String?,
    val strategy: String?,
    val inputFile: String?,
    val progress: Int?,
    val status: String?,
    val total: Int?,
    val errorMessage: String?,
    val errorTrace: String?
)

data class InputFile(
    val original: String?
)