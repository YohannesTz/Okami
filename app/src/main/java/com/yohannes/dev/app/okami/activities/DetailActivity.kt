package com.yohannes.dev.app.okami.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import coil.load
import com.yohannes.dev.app.okami.R
import com.yohannes.dev.app.okami.databinding.ActivityDetailBinding
import com.yohannes.dev.app.okami.models.Data

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var passedItem:Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        passedItem = intent.getSerializableExtra("currentItem") as Data

        val imageLink = passedItem.attributes.posterImage?.medium

        ViewCompat.setTransitionName(binding.poster, "poster_image")


        binding.poster.load(imageLink) {
            crossfade(true)
            crossfade(800)
        }

        binding.mainTitle.text = passedItem.attributes.canonicalTitle
        binding.episodesChapters.text = passedItem.attributes.episodeCount.toString()
        binding.status.text = passedItem.attributes.status
        binding.score.text = passedItem.attributes.averageRating
        binding.synopsis.text = passedItem.attributes.description
        binding.rankText.text = passedItem.attributes.favoritesCount.toString()
        binding.membersText.text = passedItem.attributes.userCount.toString()
        binding.popularityText.text = passedItem.attributes.ratingRank.toString()
        binding.startDate.text = passedItem.attributes.startDate
        binding.endDate.text = passedItem.attributes.endDate

        val thumbnail = "https://img.youtube.com/vi/${passedItem.attributes.youtubeVideoId}/0.jpg"
        if (passedItem.type == "anime" && passedItem.attributes.youtubeVideoId?.isNotEmpty() == true) {
            binding.preview.load(thumbnail) {
                crossfade(true)
                crossfade(800)
            }
            binding.preview.setOnClickListener {
                val intent = Intent(this, PlayerActivity::class.java)
                intent.putExtra("videoId", passedItem.attributes.youtubeVideoId)
                startActivity(intent)
            }
        } else {
            binding.preview.visibility = View.GONE
            binding.opening.visibility = View.GONE
            binding.playImage.visibility = View.GONE
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
                intent.putExtra(Intent.EXTRA_TEXT, "Hi check out this ${passedItem.type}! \n \n https://kitsu.io/anime/${passedItem.id}" )
                startActivity(Intent.createChooser(intent, "Share with:"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}