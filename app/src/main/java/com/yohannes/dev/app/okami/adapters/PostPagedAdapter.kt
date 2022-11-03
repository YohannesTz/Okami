package com.yohannes.dev.app.okami.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.github.yohannestz.kraw.models.PostData
import com.yohannes.dev.app.okami.databinding.PostListingItemBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class  PostPagedAdapter: PagingDataAdapter<PostData, PostPagedAdapter.PostViewHolder>(diffCallback) {

    inner class PostViewHolder(val binding: PostListingItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PostData>() {
            override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
                return oldItem.postId == newItem.postId
            }

            override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
                return oldItem == newItem
            }
        }
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = getItem(position)
        val post = currentItem?.post
        val user = currentItem?.user
        Log.e("holder-binder", currentItem.toString())

        holder.binding.apply {
            postItemUserName.text = user?.name

            try {
                val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                formatter.timeZone = TimeZone.getTimeZone("UTC");
                val date: Date = post?.createdAt?.let { formatter.parse(it) } as Date
                val output: Long = date.time / 1000L
                val str = output.toString()
                val timestamp = str.toLong() * 1000
                postItemTimeStamp.text = TimeAgo.using(timestamp);
            } catch (ex: Exception) {
                ex.printStackTrace()
                postItemTimeStamp.text = post?.createdAt.toString()
            }

            postLikesCount.text = "${post?.postLikesCount.toString()} Likes"
            postCommentsCount.text = "${post?.commentsCount.toString()} Comments"

            postContent.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(post?.contentFormatted, Html.FROM_HTML_MODE_COMPACT)
            } else {
                Html.fromHtml(post?.contentFormatted)
            }
            postItemUserProfile.load(user?.coverImage?.tiny) {
                crossfade(true)
                crossfade(500)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(PostListingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

}