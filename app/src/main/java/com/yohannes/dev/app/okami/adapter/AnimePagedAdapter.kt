package com.yohannes.dev.app.okami.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}