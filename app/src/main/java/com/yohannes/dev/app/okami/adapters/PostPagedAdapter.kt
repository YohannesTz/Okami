package com.yohannes.dev.app.okami.adapters

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.yohannestz.kraw.models.PostCollection
import com.yohannes.dev.app.okami.databinding.PostListingItemBinding

class  PostPagedAdapter: PagingDataAdapter<PostCollection, PostPagedAdapter.PostViewHolder>(diffCallback) {

    inner class PostViewHolder(val binding: PostListingItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PostCollection>() {
            override fun areItemsTheSame(oldItem: PostCollection, newItem: PostCollection): Boolean {
                return oldItem.attributes[0] == newItem.attributes[0]
            }

            override fun areContentsTheSame(oldItem: PostCollection, newItem: PostCollection): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = getItem(position)
        val attributes = currentItem?.attributes?.get(position)
        val user = currentItem?.includes?.get(position)
        //holder.binding.postContent.text = currentItem.content
        //holder.binding.postItemTimeStamp.text = currentItem.editedAt
        //holder.binding.postContent.text = currentItem.toString()
        holder.binding.postItemUserName.text = user?.name
        holder.binding.postItemTimeStamp.text = attributes?.createdAt
        holder.binding.postItemUserProfile.load(user?.coverImage?.tiny) {
            crossfade(true)
            crossfade(500)
        }

        holder.binding.postContent.text = attributes?.content
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(PostListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

}