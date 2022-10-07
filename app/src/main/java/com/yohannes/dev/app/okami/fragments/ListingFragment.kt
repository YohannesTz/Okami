package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.yohannes.dev.app.okami.databinding.FragmentListingBinding
import com.yohannes.dev.app.okami.enums.ListingType
import com.yohannes.dev.app.okami.viewmodel.AnimeViewModel
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.adapter.AnimePagedAdapter
import com.yohannes.dev.app.okami.adapter.CharacterPagedAdapter
import com.yohannes.dev.app.okami.adapter.SearchAdapter
import com.yohannes.dev.app.okami.models.Data
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ListingFragment(private val listingType: ListingType) : Fragment() {

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    private lateinit var animeAdapter: AnimePagedAdapter
    private lateinit var characterAdapter: CharacterPagedAdapter
    private val viewModel by viewModels<AnimeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        val view = binding.root
        when (listingType) {
            ListingType.ANIME -> {
                setupRecyclerView()
                loadAnimeData()
            }
            ListingType.CHARACTER -> {
                setupRecyclerView()
                loadCharacterData()
            }
            else -> {
                setupRecyclerView()
                loadMangaData()
            }
        }

        _binding!!.swipeContainer.setOnRefreshListener {
            when (listingType) {
                ListingType.ANIME -> {
                    refreshAnimeAdapter()
                }
                ListingType.CHARACTER -> {
                    refreshCharacterAdapter()
                }
                else -> {
                    refreshCharacterAdapter()
                }
            }
        }

        return view
    }

    private fun refreshCharacterAdapter() {
        characterAdapter.refresh()
        _binding!!.swipeContainer.isRefreshing = false
    }

    private fun refreshAnimeAdapter() {
        animeAdapter.refresh()
        _binding!!.swipeContainer.isRefreshing = false
    }

    private fun loadCharacterData() {
        lifecycleScope.launch {
            viewModel.characterData.collect{ pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }
        _binding!!.progressBar.visibility = View.GONE
    }

    private fun loadAnimeData() {
        lifecycleScope.launch {
            viewModel.listData.collect{ pagingData ->
                animeAdapter.submitData(pagingData)
            }
        }
        _binding!!.progressBar.visibility = View.GONE
    }

    private fun loadMangaData() {
        lifecycleScope.launch {
            viewModel.mangaData.collect{ pagingData ->
                animeAdapter.submitData(pagingData)
            }
        }
        _binding!!.progressBar.visibility = View.GONE
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