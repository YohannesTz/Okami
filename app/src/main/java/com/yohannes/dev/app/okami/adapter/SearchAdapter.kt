package com.yohannes.dev.app.okami.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yohannes.dev.app.okami.databinding.ListItemBinding
import com.yohannes.dev.app.okami.databinding.SearchListItemBinding
import com.yohannes.dev.app.okami.models.Data


class SearchAdapter(var list: ArrayList<Data>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: SearchListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) {
            binding.name.text = item.attributes.canonicalTitle
            binding.japName.text = item.attributes.titles?.jaJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SearchListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}