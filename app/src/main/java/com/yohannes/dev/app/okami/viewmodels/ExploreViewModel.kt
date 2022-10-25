package com.yohannes.dev.app.okami.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.yohannestz.kraw.data.network.KitsuClient
import com.yohannes.dev.app.okami.datasource.AnimePagingSource
import com.yohannes.dev.app.okami.datasource.MangaPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class ExploreViewModel: ViewModel() {
    private val kitsuClient = KitsuClient()
    val animeListData = Pager(PagingConfig(pageSize = 1)) {
        AnimePagingSource(kitsuClient)
    }.flow.cachedIn(viewModelScope)

    val mangaListData = Pager(PagingConfig(pageSize = 1)) {
        MangaPagingSource(kitsuClient)
    }.flow.cachedIn(viewModelScope)

}