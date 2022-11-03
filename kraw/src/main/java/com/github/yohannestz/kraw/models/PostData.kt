package com.github.yohannestz.kraw.models

data class PostData(
    val postId: String?,
    val post: Post?,
    val userId: String?,
    val user: User?
)
