package com.gnarbaiz.android.news.ui

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gnarbaiz.android.news.databinding.NewsItemBinding
import com.gnarbaiz.android.news.domain.Article
import com.gnarbaiz.android.news.util.layoutInflater

class NewsAdapter(val callback: OnClickListener) : ListAdapter<Article, NewsAdapter.NewsViewHolder>(DiffCallback) {

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder.from(parent)

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    /**
     * ViewHolder for News items. All work is done by data binding.
     */
    class NewsViewHolder(val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: Article, newsCallback: OnClickListener) {
            with(binding) {
                article = news
                poster = articlePoster
                title = articleTitle
                description = articleDescription
                callback = newsCallback
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): NewsViewHolder {
                val binding = NewsItemBinding.inflate(
                    parent.context.layoutInflater,
                    parent,
                    false
                )
                return NewsViewHolder(binding)
            }
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Article]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Article]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [Article]
     */
    class OnClickListener(val clickListener: (article: Article, imageView: ImageView, titleTextView: TextView, descriptionTextView : TextView) -> Unit) {
        fun onClick(article: Article, imageView: ImageView, titleTextView: TextView, descriptionTextView : TextView) =
            clickListener(article, imageView, titleTextView, descriptionTextView)
    }
}