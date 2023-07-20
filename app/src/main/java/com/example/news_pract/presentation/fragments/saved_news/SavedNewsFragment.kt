package com.example.news_pract.presentation.fragments.saved_news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_pract.App
import com.example.news_pract.R
import com.example.news_pract.data.remote.Article
import com.example.news_pract.databinding.FragmentLatestNewsBinding
import com.example.news_pract.databinding.FragmentSavedNewsBinding

import com.example.news_pract.presentation.fragments.latest_news.NewsAdapter
import com.example.news_pract.presentation.fragments.more_info.ArticleViewModel
import com.example.news_pract.presentation.fragments.more_info.ArticleViewModelFactory
import kotlinx.coroutines.launch


class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding!!
    val viewModel by viewModels<SavedNewsViewModel> { SavedNewsViewModelFactory((activity?.application as App).newsRepository) }
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getSavedNews().collect { articles ->
                newsAdapter.updateList(articles)
            }
        }

    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}