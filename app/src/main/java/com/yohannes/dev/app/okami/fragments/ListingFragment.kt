package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.adapter.ItemPagedAdapter
import com.yohannes.dev.app.okami.databinding.FragmentListingBinding
import com.yohannes.dev.app.okami.enums.ListingType
import com.yohannes.dev.app.okami.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val LISTING_TYPE = "listingType"

@AndroidEntryPoint
class ListingFragment() : Fragment() {

    private var listingType: String? = null

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    private lateinit var itemsAdapter: ItemPagedAdapter
    private val viewModel by viewModels<AnimeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listingType = it.getString(LISTING_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListingBinding.inflate(inflater, container, false)
        val view = binding.root
        _binding!!.shimmerLayout.startShimmer()
        setupRecyclerView()
        _binding!!.retryButton.setOnClickListener {
            itemsAdapter.refresh()
        }
        when (listingType) {
            ListingType.ANIME.toString() -> {
                loadAnimeData()
            }
            else -> {
                loadMangaData()
            }
        }
        return view
    }

    private fun loadAnimeData() {
        lifecycleScope.launchWhenCreated {
            viewModel.listData.collect { pagingData ->
                launch(Dispatchers.Main) {
                    _binding!!.retryButton.setOnClickListener {
                        itemsAdapter.refresh()
                    }
                    itemsAdapter.loadStateFlow.collectLatest { loadStates ->
                        when (loadStates.refresh) {
                            is LoadState.Loading -> {
                                _binding!!.loadingLayout.visibility = View.VISIBLE
                                _binding!!.errorLayout.visibility = View.GONE
                            }
                            is LoadState.Error -> {
                                _binding!!.errorLayout.visibility = View.VISIBLE
                                _binding!!.loadingLayout.visibility = View.GONE
                            }
                            is LoadState.NotLoading -> {
                                _binding!!.loadingLayout.visibility = View.GONE
                                _binding!!.errorLayout.visibility = View.GONE
                            }
                        }
                    }
                }
                itemsAdapter.submitData(pagingData)
            }
        }
    }

    private fun loadMangaData() {
        lifecycleScope.launchWhenCreated {
            viewModel.mangaData.collect { pagingData ->
                launch(Dispatchers.Main) {
                    itemsAdapter.loadStateFlow.collectLatest { loadStates ->
                        when (loadStates.refresh) {
                            is LoadState.Loading -> {
                                _binding!!.loadingLayout.visibility = View.VISIBLE
                                _binding!!.errorLayout.visibility = View.GONE
                            }
                            is LoadState.Error -> {
                                _binding!!.errorLayout.visibility = View.VISIBLE
                                _binding!!.loadingLayout.visibility = View.GONE
                            }
                            is LoadState.NotLoading -> {
                                _binding!!.loadingLayout.visibility = View.GONE
                                _binding!!.errorLayout.visibility = View.GONE
                            }
                        }
                    }
                }
                itemsAdapter.submitData(pagingData)
            }
        }
    }

    private fun setupRecyclerView() {
        itemsAdapter = ItemPagedAdapter()
        _binding!!.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemsAdapter
            setHasFixedSize(true)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(listingType: ListingType) =
            ListingFragment().apply {
                arguments = Bundle().apply {
                    putString(LISTING_TYPE, listingType.toString())
                }
            }
    }
}