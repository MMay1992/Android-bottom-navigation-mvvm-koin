package com.shopping.app.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.shopping.app.R
import com.shopping.app.databinding.ItemMainBinding
import com.shopping.app.vo.NewsResponse

class HomeAdapter : ListAdapter<NewsResponse, HomeAdapter.ViewHolder>(
    DIFF_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.home_item,
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