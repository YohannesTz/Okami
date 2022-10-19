package com.github.yohannestz.kraw

import com.github.yohannestz.kraw.utils.Endpoints
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object KitsuRetrofitClient {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL_EDGE)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}