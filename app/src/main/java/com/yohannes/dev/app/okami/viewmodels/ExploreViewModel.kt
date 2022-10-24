package com.yohannes.dev.app.okami.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.yohannestz.kraw.data.network.KitsuClient
import com.yohannes.dev.app.okami.datasource.AnimePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel
    @Inject constructor(kitsuClient: KitsuClient): ViewModel() {
    val animeListData = Pager(PagingConfig(pageSize = 1)) {
        AnimePagingSource(kitsuClient)
    }.flow.cachedIn(viewModelScope)

}