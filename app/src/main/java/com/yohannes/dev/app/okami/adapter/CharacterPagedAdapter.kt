package com.yohannes.dev.app.okami.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yohannes.dev.app.okami.databinding.ListItemBinding
import com.yohannes.dev.app.okami.models.CharacterData

class CharacterPagedAdapter:PagingDataAdapter<CharacterData, CharacterPagedAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CharacterData>() {
            override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.v("CharacterPagedAdapter", "OnbindViewHolder")
        val currentItem = getItem(position)
        holder.binding.apply {
            title.text = currentItem?.attributes?.canonicalname ?: "title"
            val imageLink = currentItem?.attributes?.image?.medium
            poster.load(imageLink) {
                crossfade(true)
                crossfade(800)
            }
            score.text = ""
            mediaStatus.text = ""
            jptitle.text = currentItem?.attributes?.slug
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterPagedAdapter.MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}