package com.github.yohannestz.kraw

import com.github.yohannestz.kraw.utils.Endpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object KitsuRetrofitClient {

    @Provides
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL_EDGE)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}