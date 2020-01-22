package com.bottom.navigation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bottom.navigation.R
import com.bottom.navigation.databinding.ItemMainBinding
import com.bottom.navigation.vo.NewsResponse

class MainAdapter : ListAdapter<NewsResponse, MainAdapter.ViewHolder>(
    DIFF_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_main,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val mBind: ItemMainBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(mBind.root) {

        fun bind(item: NewsResponse) {
            mBind.news = item
            mBind.executePendingBindings()
        }
    }

    companion object {
        val DIFF_COMPARATOR = object : DiffUtil.ItemCallback<NewsResponse>() {

            override fun areItemsTheSame(oldItem: NewsResponse, newItem: NewsResponse): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NewsResponse, newItem: NewsResponse): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}