package com.example.news_pract.presentation.fragments.more_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.news_pract.App
import com.example.news_pract.R
import com.example.news_pract.data.remote.Article
import com.example.news_pract.databinding.FragmentArticleBinding
import com.example.news_pract.databinding.FragmentTypePINBinding
import com.example.news_pract.presentation.fragments.latest_news.NewsAdapter

import com.example.news_pract.presentation.fragments.latest_news.NewsViewModel
import com.example.news_pract.presentation.fragments.latest_news.NewsViewModelFactory
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    val viewModel by viewModels<ArticleViewModel> { ArticleViewModelFactory((activity?.application as App).newsRepository) }
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = arguments?.getParcelable(ARTICLE_KEY, Article::class.java)
        binding.webView.apply {
            webViewClient = WebViewClient()
            if (article != null) {
                loadUrl(article.url)
            }
        }
        binding.fab.setOnClickListener {

            if (article != null) {
                viewModel.saveNews(article)
                Snackbar.make(
                    view,
                    resources.getString(R.string.success_adding),
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    view,
                    resources.getString(R.string.unsuccessful_adding),
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object{
        const val ARTICLE_KEY = "article"
    }
}