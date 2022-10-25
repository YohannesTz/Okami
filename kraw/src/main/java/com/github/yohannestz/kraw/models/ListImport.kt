package com.github.yohannestz.kraw.models

import java.io.Serializable

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
): Serializable

data class InputFile(
    val original: String?
): Serializable