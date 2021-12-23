package com.yohannes.dev.app.okami.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yohannes.dev.app.okami.enums.ListingType
import com.yohannes.dev.app.okami.fragments.ListingFragment

class TabLayoutAdapter(fragmentManager: FragmentManager, lifecycle:Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val ITEM_SIZE = 2

    override fun getItemCount(): Int {
        return ITEM_SIZE
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return ListingFragment(ListingType.ANIME)
        } else if (position == 1)
            return ListingFragment(ListingType.MANGA)
        return ListingFragment(ListingType.CHARACTER)
    }

}