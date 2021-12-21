package com.yohannes.dev.app.okami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.yohannes.dev.app.okami.adapter.TabLayoutAdapter
import com.yohannes.dev.app.okami.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val titlesArray = arrayOf(
        "Anime",
        "Manga",
        "Characters"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.pager
        val tabLayout = binding.tabLayout

        val adapter = TabLayoutAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = titlesArray[position]
        }.attach()
    }
}