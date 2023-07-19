package com.example.news_pract.presentation.fragments.latest_news

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_pract.data.remote.Article
import com.example.news_pract.databinding.FragmentLatestNewsBinding
import com.example.news_pract.databinding.ItemArticlePreviewBinding

class NewsAdapter() :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(private val binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.apply {
                Glide.with(this.root).load(article.urlToImage).into(ivArticleImage)
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt
                tvAuthorsName.text = article.author
                root.setOnClickListener {
                    onItemClickListener?.let { it(article) }
                }
            }
        }
    }

    private val articleList: MutableList<Article> = mutableListOf()

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding =
            ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Article>) {
        articleList.addAll(list)
        notifyDataSetChanged()
    }
}