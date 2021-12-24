package com.yohannes.dev.app.okami.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yohannes.dev.app.okami.activities.DetailActivity
import com.yohannes.dev.app.okami.databinding.ListItemBinding
import com.yohannes.dev.app.okami.models.Data

class AnimePagedAdapter:PagingDataAdapter<Data, AnimePagedAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            title.text = currentItem?.attributes?.canonicalTitle ?: "title"
            val imageLink = currentItem?.attributes?.posterImage?.medium
            poster.load(imageLink) {
                crossfade(true)
                crossfade(800)
            }
            score.text = currentItem?.attributes?.averageRating
            val status = currentItem?.attributes?.status
            mediaStatus.text = "($status)"
            jptitle.text = currentItem?.attributes?.titles?.jaJp
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            //val options = ActivityOptionsCompat.makeSceneTransitionAnimation(holder.itemView.context, holder.binding.poster, "poster_image")
            ViewCompat.setTransitionName(holder.binding.poster, "poster_image")
            intent.putExtra("currentItem", currentItem)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}