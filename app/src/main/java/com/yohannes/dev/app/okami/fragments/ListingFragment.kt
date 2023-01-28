package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.adapter.AnimePagedAdapter
import com.yohannes.dev.app.okami.adapter.CharacterPagedAdapter
import com.yohannes.dev.app.okami.adapter.SearchAdapter
import com.yohannes.dev.app.okami.databinding.FragmentListingBinding
import com.yohannes.dev.app.okami.enums.ListingType
import com.yohannes.dev.app.okami.models.Data
import com.yohannes.dev.app.okami.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListingFragment(val listingType: ListingType) : Fragment() {

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    private lateinit var animeAdapter: AnimePagedAdapter

    private lateinit var characterAdapter: CharacterPagedAdapter
    private val viewModel by viewModels<AnimeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        val view = binding.root
        _binding!!.loadingLayout.startShimmer()
        when (listingType) {
            ListingType.ANIME -> {
                setupRecyclerView()
                loadAnimeData()
            }
            else -> {
                setupRecyclerView()
                loadMangaData()
            }
        }
        return view
    }

    private fun loadAnimeData() {
        lifecycleScope.launchWhenCreated {
            viewModel.listData.collect{ pagingData ->
                launch(Dispatchers.Main) {
                    animeAdapter.loadStateFlow.collectLatest { loadStates ->
                        _binding!!.loadingLayout.isVisible = loadStates.refresh is LoadState.Loading
                    }
                }
                animeAdapter.submitData(pagingData)
            }
        }
    }

    private fun loadMangaData() {
        lifecycleScope.launchWhenCreated {
            viewModel.mangaData.collect{ pagingData ->
                launch(Dispatchers.Main) {
                    animeAdapter.loadStateFlow.collectLatest { loadStates ->
                        _binding!!.loadingLayout.isVisible = loadStates.refresh is LoadState.Loading
                    }
                }
                animeAdapter.submitData(pagingData)
            }
        }
    }

    private fun setupRecyclerView() {
        animeAdapter = AnimePagedAdapter()
        characterAdapter = CharacterPagedAdapter()
        _binding!!.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = animeAdapter
            setHasFixedSize(true)
        }
    }
}