package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.adapter.AnimePagedAdapter
import com.yohannes.dev.app.okami.adapter.CharacterPagedAdapter
import com.yohannes.dev.app.okami.databinding.FragmentListingBinding
import com.yohannes.dev.app.okami.enums.ListingType
import com.yohannes.dev.app.okami.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

private const val argOne = "LISTING_TYPE"

@AndroidEntryPoint
class ListingFragment() : Fragment() {

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!
    private var listingType:String? = null

    private lateinit var animeAdapter: AnimePagedAdapter
    private lateinit var characterAdapter: CharacterPagedAdapter
    private val viewModel by viewModels<AnimeViewModel>()

    companion object {
        /**
         * @param listingType The type of listing this fragment was supposed to show.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(listingType: ListingType) =
            ListingFragment().apply {
                arguments = Bundle().apply {
                    putString(argOne, listingType.toString())
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        val view = binding.root
        arguments?.let {
            listingType = it.getString(argOne)
        }
        setupRecyclerView()
        when (listingType) {
            ListingType.ANIME.toString() -> {
                loadAnimeData()
            }
            ListingType.CHARACTER.toString() -> {
                loadCharacterData()
            }
            else -> {
                loadMangaData()
            }
        }

        _binding!!.swipeContainer.setOnRefreshListener {
            when (listingType) {
                ListingType.ANIME.toString() -> {
                    refreshAnimeAdapter()
                }
                ListingType.CHARACTER.toString() -> {
                    refreshCharacterAdapter()
                }
                else -> {
                    refreshMangaAdapter()
                }
            }
        }

        return view
    }

    private fun refreshCharacterAdapter() {
        characterAdapter.refresh()
        _binding!!.swipeContainer.isRefreshing = false
    }

    private fun refreshMangaAdapter() {
        animeAdapter.refresh()
        _binding!!.swipeContainer.isRefreshing = false
    }

    private fun refreshAnimeAdapter() {
        animeAdapter.refresh()
        _binding!!.swipeContainer.isRefreshing = false
    }

    private fun loadCharacterData() {
        lifecycleScope.launch {
            viewModel
                .characterData
                .onStart {
                    _binding!!.progressBar.visibility = View.VISIBLE
                }
                .catch {
                    _binding!!.progressBar.visibility = View.GONE
                    _binding!!.swipeContainer.visibility = View.GONE
                    _binding!!.errorText.visibility = View.VISIBLE
                }
                .collect{ pagingData ->
                    _binding!!.progressBar.visibility = View.GONE
                    characterAdapter.submitData(pagingData)
                }
        }
    }

    private fun loadAnimeData() {
        lifecycleScope.launch {
            viewModel
                .listData
                .onStart {
                    _binding!!.progressBar.visibility = View.VISIBLE
                }
                .catch {
                    _binding!!.progressBar.visibility = View.GONE
                    _binding!!.swipeContainer.visibility = View.GONE
                    _binding!!.errorText.visibility = View.VISIBLE
                }
                .collect{ pagingData ->
                    _binding!!.progressBar.visibility = View.GONE
                    animeAdapter.submitData(pagingData)
                }
        }
    }

    private fun loadMangaData() {
        lifecycleScope.launch {
            viewModel
                .mangaData
                .onStart {
                    _binding!!.progressBar.visibility = View.VISIBLE
                }
                .catch {
                    _binding!!.progressBar.visibility = View.GONE
                    _binding!!.swipeContainer.visibility = View.GONE
                    _binding!!.errorText.visibility = View.VISIBLE
                }
                .collect{ pagingData ->
                    _binding!!.progressBar.visibility = View.GONE
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