package com.yohannes.dev.app.okami.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yohannes.dev.app.okami.api.ApiService
import com.yohannes.dev.app.okami.paging.AnimePagingSource
import com.yohannes.dev.app.okami.paging.MangaPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel
@Inject constructor(private val apiService: ApiService): ViewModel(){
    val listData = Pager(PagingConfig(pageSize = 1)) {
        AnimePagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

    val mangaData = Pager(PagingConfig(pageSize = 1)) {
        MangaPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}