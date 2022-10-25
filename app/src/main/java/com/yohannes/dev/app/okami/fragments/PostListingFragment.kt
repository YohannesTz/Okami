package com.yohannes.dev.app.okami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.adapters.PostPagedAdapter
import com.yohannes.dev.app.okami.databinding.FragmentPostListingBinding
import com.yohannes.dev.app.okami.viewmodels.HomeViewHolder
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"

class PostListingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var postListingType: String? = null

    private lateinit var postListingBinding: FragmentPostListingBinding
    private lateinit var postPagedAdapter: PostPagedAdapter
    private val viewModel by viewModels<HomeViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            postListingType = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        postListingBinding = FragmentPostListingBinding.inflate(inflater, container, false)
        val view = postListingBinding.root

        setupRecyclerView()

        when (postListingType) {
            "Following" -> {

            }

            "Global" -> {
                loadGlobalPosts()
            }
        }

        return view
    }

    private fun loadGlobalPosts() {
        lifecycleScope.launch {
            viewModel
                .globalPostList
                .collect { pagingData ->
                    postPagedAdapter.submitData(pagingData)
                }
        }
    }

    private fun setupRecyclerView() {
        postPagedAdapter = PostPagedAdapter()
        postListingBinding.postListingRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = postPagedAdapter
            setHasFixedSize(true)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment PostListingFragment.
         */
        @JvmStatic
        fun newInstance(param1: String) =
            PostListingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}