package com.yohannes.dev.app.okami.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.yohannestz.kraw.data.network.KitsuClient
import com.yohannes.dev.app.okami.datasource.GlobalPostPagingSource

class HomeViewHolder: ViewModel() {
    private val kitsuClient = KitsuClient()

    val globalPostList = Pager(PagingConfig(pageSize = 1)) {
        GlobalPostPagingSource(kitsuClient)
    }.flow.cachedIn(viewModelScope)
}