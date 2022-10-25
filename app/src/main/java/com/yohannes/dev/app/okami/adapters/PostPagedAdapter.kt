package com.yohannes.dev.app.okami.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.yohannestz.kraw.models.Data
import com.github.yohannestz.kraw.models.Post
import com.yohannes.dev.app.okami.databinding.PostListingItemBinding

class  PostPagedAdapter: PagingDataAdapter<Data, PostPagedAdapter.PostViewHolder>(MediaPagedAdapter.diffCallback) {

    inner class PostViewHolder(val binding: PostListingItemBinding): RecyclerView.ViewHolder(binding.root)

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

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = getItem(position) as Post
        holder.binding.postContent.text = currentItem.content
        holder.binding.postItemTimeStamp.text = currentItem.editedAt

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(PostListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

}