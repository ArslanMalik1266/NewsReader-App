package com.example.newsreaderpractice.adaptor

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsreaderpractice.R

class NewsAdapter(
    private val onItemClick: (NewsItem) -> Unit,
    private val onBookmarkToggle: (NewsItem) -> Unit
) : androidx.recyclerview.widget.ListAdapter<NewsItem, NewsAdapter.NewsViewHolder>(diffCallbacks()) {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgNews: ImageView = itemView.findViewById(R.id.ivThumbnail)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvSource: TextView = itemView.findViewById(R.id.tvSource)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val bookmarkButton: ImageView = itemView.findViewById(R.id.ibBookmark)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val bind = getItem(position)
        holder.tvTitle.text = bind.title
        holder.tvSource.text = bind.source
        holder.tvDate.text = bind.date

        Glide.with(holder.itemView.context)
            .load(bind.imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(holder.imgNews)

        holder.bookmarkButton.setImageResource(
            if (bind.isBookmarked) R.drawable.img_2 else R.drawable.img_1
        )

        holder.bookmarkButton.setOnClickListener {
            val updatedItem = bind.copy(isBookmarked = !bind.isBookmarked)
            onBookmarkToggle(updatedItem)
        }

        holder.itemView.setOnClickListener {
            onItemClick(bind)
        }
    }

    class diffCallbacks : DiffUtil.ItemCallback<NewsItem>() {
        override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem == newItem
        }
    }
}