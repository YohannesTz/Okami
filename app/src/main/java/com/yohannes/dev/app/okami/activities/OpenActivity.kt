package com.yohannes.dev.app.okami.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.yohannes.dev.app.okami.R
import com.yohannes.dev.app.okami.api.ApiService
import com.yohannes.dev.app.okami.databinding.ActivityOpenBinding
import com.yohannes.dev.app.okami.di.AppModule
import com.yohannes.dev.app.okami.models.Data
import com.yohannes.dev.app.okami.util.Constants
import kotlinx.coroutines.launch

class OpenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOpenBinding
    private var foundData: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.progressBar.visibility = View.VISIBLE
        binding.synopsis.text = getString(R.string.lorem_ipsun)

        val uri: Uri? = intent.data
        if (uri != null) {
            binding.mainTitle.text = uri.lastPathSegment
            lifecycleScope.launch {
                foundData = loadItem(uri.lastPathSegment)
                binding.progressBar.visibility = View.GONE
                setupViews()
                binding.detailsScroll.visibility = View.VISIBLE
            }
        }
    }
    
    private fun setupViews() {
        val imageLink = foundData?.attributes?.posterImage?.medium
        binding.poster.load(imageLink) {
            crossfade(true)
            crossfade(800)
        }

        binding.mainTitle.text = foundData?.attributes?.canonicalTitle
        binding.episodesChapters.text = foundData?.attributes?.episodeCount.toString()
        binding.status.text = foundData?.attributes?.status
        binding.score.text = foundData?.attributes?.averageRating
        binding.synopsis.text = foundData?.attributes?.description
        binding.rankText.text = foundData?.attributes?.favoritesCount.toString()
        binding.membersText.text = foundData?.attributes?.userCount.toString()
        binding.popularityText.text = foundData?.attributes?.ratingRank.toString()
        binding.startDate.text = foundData?.attributes?.startDate
        binding.endDate.text = foundData?.attributes?.endDate

        val thumbnail = "https://img.youtube.com/vi/${foundData?.attributes?.youtubeVideoId}/0.jpg"
        if (foundData?.type == "anime" && foundData?.attributes?.youtubeVideoId?.isNotEmpty() == true) {
            binding.preview.load(thumbnail) {
                crossfade(true)
                crossfade(800)
            }
            binding.preview.setOnClickListener {
                val intent = Intent(this, PlayerActivity::class.java)
                intent.putExtra("videoId", foundData!!.attributes.youtubeVideoId)
                startActivity(intent)
            }
        } else {
            binding.preview.visibility = View.INVISIBLE
            binding.opening.visibility = View.INVISIBLE
        }
    }

    private suspend fun loadItem(slug: String?) : Data? {
        try {
            val id = Integer.parseInt(slug!!)

            val apiService: ApiService = AppModule.provideRetrofitInstance(Constants.BASE_URL)
            val response = apiService.findByID(id)

            return response.body()?.data
        } catch (e: NumberFormatException) {
            val apiService: ApiService = AppModule.provideRetrofitInstance(Constants.BASE_URL)
            val response = apiService.findBySlug(slug!!)
            val data = response.body()?.data ?: emptyList()
            val responseData = arrayListOf<Data>()
            responseData.addAll(data)
            if (responseData.size > 0) {
                return responseData[0]
            }
            return null
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.details_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
            R.id.share_menu -> {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hi check out this ${foundData?.type}! \n \n https://kitsu.io/anime/${foundData?.id}" )
                startActivity(Intent.createChooser(intent, "Share with:"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

}