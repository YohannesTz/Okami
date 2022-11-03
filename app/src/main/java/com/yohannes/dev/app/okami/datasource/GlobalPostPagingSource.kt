package com.yohannes.dev.app.okami.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.yohannestz.kraw.data.network.KitsuClient
import com.github.yohannestz.kraw.models.PostData
import javax.inject.Inject

class GlobalPostPagingSource @Inject constructor(private  val kitsuClient: KitsuClient):
        PagingSource<Int, PostData>() {
    override fun getRefreshKey(state: PagingState<Int, PostData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostData> {
        return try {
            val currentPage = params.key?: 1
            val responseData = mutableListOf<PostData>()
            kitsuClient.getPosts(currentPage)?.let {
                responseData.addAll(it)
            }

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else 1,
                nextKey = currentPage.plus(15)
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

}