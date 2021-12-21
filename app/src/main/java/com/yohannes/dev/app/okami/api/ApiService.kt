package com.yohannes.dev.app.okami.api

import com.yohannes.dev.app.okami.models.CharacterResponse
import com.yohannes.dev.app.okami.models.ResponseApi
import com.yohannes.dev.app.okami.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface ApiService {
    @GET(Constants.ANIME_ENDPOINT)
    suspend fun getAnime(@Query("page[limit]") pageLimit: Int, @Query("page[offset]") offset: Int) : Response<ResponseApi>

    @GET(Constants.MANGA_ENDPOINT)
    suspend fun getManga(@Query("page[limit]") pageLimit: Int, @Query("page[offset]") offset: Int) : Response<ResponseApi>

    @GET(Constants.CHARACTER_ENDPOINT)
    suspend fun getCharacter(@Query("page[limit]") pageLimit: Int, @Query("page[offset]") offset: Int) : Response<CharacterResponse>
}