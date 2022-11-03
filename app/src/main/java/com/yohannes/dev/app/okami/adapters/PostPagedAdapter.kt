package com.yohannes.dev.app.okami.adapters

import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.yohannestz.kraw.models.PostData
import com.yohannes.dev.app.okami.databinding.PostListingItemBinding

class  PostPagedAdapter: PagingDataAdapter<PostData, PostPagedAdapter.PostViewHolder>(diffCallback) {

    inner class PostViewHolder(val binding: PostListingItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PostData>() {
            override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = getItem(position)
        val post = currentItem?.post
        val user = currentItem?.user
        holder.binding.postContent.text = currentItem.toString()
        Log.e("holder-binder", currentItem.toString())
        holder.binding.postItemUserName.text = user?.name
        holder.binding.postItemTimeStamp.text = post?.createdAt
        holder.binding.postItemUserProfile.load(user?.coverImage?.tiny) {
            crossfade(true)
            crossfade(500)
        }

        holder.binding.postContent.text = post?.content
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(PostListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

}