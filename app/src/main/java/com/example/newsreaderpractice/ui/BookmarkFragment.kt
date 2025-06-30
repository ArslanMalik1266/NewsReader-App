package com.example.newsreaderpractice.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreaderpractice.R
import com.example.newsreaderpractice.ViewModel.NewsViewModel
import com.example.newsreaderpractice.adaptor.NewsAdapter

class BookmarkFragment : Fragment() {
    private val newsViewModel: NewsViewModel by activityViewModels()
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookmark, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBM)

        newsViewModel.initializeSharedPreferences(requireContext())

        adapter = NewsAdapter(
            onItemClick = { newsItem ->
                val intent = Intent(requireContext(), newsDetailScreen::class.java)
                intent.putExtra("newsItem", newsItem)
                startActivity(intent)
            },
            onBookmarkToggle = { newsItem ->
                newsViewModel.toggleBookmark(newsItem)
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Observe bookmarked items
        newsViewModel.bookMarkedList.observe(viewLifecycleOwner) { bookmarks ->
            adapter.submitList(bookmarks)
        }

        return view
    }
}