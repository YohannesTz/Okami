package com.yohannes.dev.app.okami.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yohannes.dev.app.okami.fragments.MediaListingFragment
import com.yohannes.dev.app.okami.fragments.PostListingFragment

class MediaListingTabLayoutAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val itemsSize = 2

    override fun getItemCount(): Int {
        return itemsSize
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MediaListingFragment.newInstance("Anime")
            }
            else -> {
                MediaListingFragment.newInstance("Manga")
            }
        }
    }

}