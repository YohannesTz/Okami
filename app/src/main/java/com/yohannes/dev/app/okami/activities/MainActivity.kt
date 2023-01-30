package com.yohannes.dev.app.okami.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yohannes.dev.app.okami.R
import com.yohannes.dev.app.okami.adapter.TabLayoutAdapter
import com.yohannes.dev.app.okami.databinding.ActivityMainBinding
import com.yohannes.dev.app.okami.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var currentTab:Int = 0
    private val titlesArray = arrayOf(
        "Anime",
        "Manga"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)

        val viewPager = binding.pager
        val tabLayout = binding.tabLayout


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                currentTab = tabLayout.selectedTabPosition
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                currentTab = tabLayout.selectedTabPosition
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                currentTab = tabLayout.selectedTabPosition
            }
        })

        val adapter = TabLayoutAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = titlesArray[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.appbarmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.github_menu -> {
                val uri: Uri = Uri.parse(Constants.PROJECT_PAGE)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            R.id.search_button -> {
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra("pos", currentTab)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}