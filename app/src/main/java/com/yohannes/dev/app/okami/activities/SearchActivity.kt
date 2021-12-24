package com.yohannes.dev.app.okami.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yohannes.dev.app.okami.R
import com.yohannes.dev.app.okami.adapter.SearchAdapter
import com.yohannes.dev.app.okami.api.ApiService
import com.yohannes.dev.app.okami.databinding.ActivityDetailBinding.inflate
import com.yohannes.dev.app.okami.databinding.ActivitySearchBinding
import com.yohannes.dev.app.okami.di.AppModule
import com.yohannes.dev.app.okami.models.Data
import com.yohannes.dev.app.okami.util.Constants
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var animeList: ArrayList<Data>

    private var timer = Timer()
    private var DELAY:Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animeList = ArrayList()
        animeList.clear()
        val currentPage = intent.getIntExtra("pos", 0)

        setupRecyelrview()

        binding.searchView.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.e("TAG","timer start")
                timer = Timer()
                timer.schedule(object : TimerTask() {
                    override fun run() {
                        Log.e("SearchSize", "Search List function")
                        lifecycleScope.launch {
                            animeList = searchItem(binding.searchView.text.toString(), currentPage)
                            Log.e("SearchSize", animeList.size.toString())
                            Log.e("Elements", animeList.toString())
                            setupRecyelrview()
                        }
                    }
                }, DELAY)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.e("TAG","timer cancel ")
                timer.cancel() //Terminates this timer,discarding any currently scheduled tasks.
                timer.purge() //Removes all cancelled tasks from this timer's task queue.
            }
        })

        //setupRecyelrview()
    }

    private fun setupRecyelrview() {
        searchAdapter = SearchAdapter(animeList)
        if (animeList.size > 0) {
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = searchAdapter
            }
        }
    }

    suspend fun searchItem(query: String, page: Int): ArrayList<Data> {
        if (page == 0) {
            val apiService: ApiService = AppModule.provideRetrofitInstance(Constants.BASE_URL)
            val response = apiService.searchAnime(query)
            val data = response.body()?.data ?: emptyList()
            val responseData = arrayListOf<Data>()
            responseData.addAll(data)
            return responseData
        }
        val apiService: ApiService = AppModule.provideRetrofitInstance(Constants.BASE_URL)
        val response = apiService.searchManga(query)
        val data = response.body()?.data ?: emptyList()
        val responseData = arrayListOf<Data>()
        responseData.addAll(data)
        return responseData
    }
}