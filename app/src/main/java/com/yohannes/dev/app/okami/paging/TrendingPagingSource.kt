package com.yohannes.dev.app.okami.paging

import com.yohannes.dev.app.okami.api.ApiService
import com.yohannes.dev.app.okami.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TrendingPagingSource (private val apiService: ApiService) {
    suspend fun getTrendingAnime(): Flow<List<Data>> {
        return flow {
            val response = apiService.trendingAnime()
            val data = response.body()?.data?: emptyList()
            val responseData = mutableListOf<Data>()
            responseData.addAll(data)

            emit(responseData)
        }.flowOn(Dispatchers.IO)
    }
}