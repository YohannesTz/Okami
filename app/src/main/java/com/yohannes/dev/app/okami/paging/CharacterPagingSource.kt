package com.yohannes.dev.app.okami.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yohannes.dev.app.okami.api.ApiService
import com.yohannes.dev.app.okami.models.CharacterData

class CharacterPagingSource(private val apiService: ApiService): PagingSource<Int, CharacterData>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterData> {
        return try {
            val currentPage = params.key?:1
            val response = apiService.getCharacter(8, currentPage)
            val data = response.body()?.data?: emptyList()
            val responseData = mutableListOf<CharacterData>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else 1,
                nextKey = currentPage.plus(8)
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}