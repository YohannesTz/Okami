package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.adapters.MediaPagedAdapter
import com.yohannes.dev.app.okami.databinding.FragmentMediaListingBinding
import com.yohannes.dev.app.okami.viewmodels.ExploreViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val ARG_PARAM = "LISTING_TYPE"

@AndroidEntryPoint
class MediaListingFragment : Fragment() {

    private var param1: String? = null

    private lateinit var mediaListingBinding: FragmentMediaListingBinding
    private lateinit var mediaPagedAdapter: MediaPagedAdapter
    private val viewModel by viewModels<ExploreViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mediaListingBinding = FragmentMediaListingBinding.inflate(inflater, container, false)
        val view = mediaListingBinding.root
        var listingType: String? = null
        arguments?.let {
            listingType = it.getString(ARG_PARAM)
        }
        setupRecyclerView()

        when (listingType) {
            "Anime" -> {
                loadAnimeListing()
            }
            "Manga" -> {
                loadMangaListing()
            }
            "User" -> {
                //loadAnimeListing()
            }
            else -> {
                loadAnimeListing()
            }
        }

        return view
    }

    private fun loadAnimeListing() {
        lifecycleScope.launch {
            viewModel
                .animeListData
                .collect { pagingData ->
                    mediaPagedAdapter.submitData(pagingData)
                }
        }
    }

    private fun loadMangaListing() {}

    private fun setupRecyclerView() {
        mediaPagedAdapter = MediaPagedAdapter()
        mediaListingBinding.mediaListing.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mediaPagedAdapter
            setHasFixedSize(true)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(listingType : String) =
            MediaListingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, param1)
                }
            }
    }
}