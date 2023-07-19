package com.example.news_pract.presentation.fragments.latest_news

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_pract.App
import com.example.news_pract.R
import com.example.news_pract.data.remote.ArticleApiModel
import com.example.news_pract.databinding.FragmentLatestNewsBinding
import com.example.news_pract.databinding.FragmentTypePINBinding
import kotlinx.coroutines.launch
import com.example.news_pract.util.Result


class LatestNewsFragment : Fragment(R.layout.fragment_latest_news) {
    val newsViewModel by viewModels<NewsViewModel> { NewsViewModelFactory((activity?.application as App).newsRepository) }
    lateinit var newsAdapter: NewsAdapter
    private var _binding: FragmentLatestNewsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLatestNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.getLatestNews("us")

        setupRecyclerView()

        viewLifecycleOwner.lifecycleScope.launch {
            newsViewModel.latestNews.collect { response ->
                when (response) {
                    is Result.Success -> {
                        hideProgressBar()
                        response.data?.let { newsResponce ->
                            newsAdapter.updateList(newsResponce.articles)
                        }

                    }

                    is Result.Error -> {
                        hideProgressBar()
                        response.message?.let { message ->
                            Log.e(TAG, "Error: $message")
                        }

                    }

                    is Result.Loading -> {
                        showProgressBar()
                    }
                }
            }
        }
    }


    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvLatestNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
