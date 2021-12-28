package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
class ListingFragment(val listingType: ListingType) : Fragment() {

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    private lateinit var animeAdapter: AnimePagedAdapter
    private lateinit var searchAdapter: SearchAdapter

    private lateinit var animeList: ArrayList<Data>

    private lateinit var characterAdapter: CharacterPagedAdapter
    private val viewModel by viewModels<AnimeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        val view = binding.root
        if (listingType == ListingType.ANIME) {
            setupRecyclerView()
            loadAnimeData()
        } else if (listingType == ListingType.CHARACTER){
            setupRecyclerView()
            loadCharacterData()
        } else {
            setupRecyclerView()
            loadMangaData()
        }
        return view
    }

    private fun loadCharacterData() {
        lifecycleScope.launch {
            viewModel.characterData.collect{ pagingData ->
                _binding!!.progressBar.visibility = View.INVISIBLE
                characterAdapter.submitData(pagingData)
            }
        }
    }

    private fun loadAnimeData() {
        lifecycleScope.launch {
            viewModel.listData.collect{ pagingData ->
                _binding!!.progressBar.visibility = View.INVISIBLE
                animeAdapter.submitData(pagingData)
            }
        }
    }

    private fun loadMangaData() {
        lifecycleScope.launch {
            viewModel.mangaData.collect{ pagingData ->
                _binding!!.progressBar.visibility = View.INVISIBLE
                animeAdapter.submitData(pagingData)
            }
        }
    }

    private fun loadTrending() {

    }

    private fun setupTrendingView() {
        searchAdapter = SearchAdapter(animeList)
        if (animeList.size > 0) {
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = searchAdapter
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