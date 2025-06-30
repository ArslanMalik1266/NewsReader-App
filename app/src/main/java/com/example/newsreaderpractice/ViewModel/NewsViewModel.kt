package com.example.newsreaderpractice.ViewModel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsreaderpractice.adaptor.NewsItem

class NewsViewModel : ViewModel() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val _newsList = MutableLiveData<List<NewsItem>>()
    val newsList: LiveData<List<NewsItem>> = _newsList

    private val _bookMarkedList = MutableLiveData<List<NewsItem>>()
    val bookMarkedList: LiveData<List<NewsItem>> = _bookMarkedList

    fun initializeSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences("NewsAppPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        loadBookmarkedItems()
    }

    private fun loadBookmarkedItems() {
        val bookmarkedItems = _newsList.value?.filter { it.isBookmarked } ?: emptyList()
        _bookMarkedList.value = bookmarkedItems
    }

    fun toggleBookmark(newsItem: NewsItem) {
        val currentList = _newsList.value?.toMutableList() ?: mutableListOf()
        val index = currentList.indexOfFirst { it.title == newsItem.title }

        if (index != -1) {
            currentList[index] = newsItem
            _newsList.value = currentList.toList() // Create new list instance
            _bookMarkedList.value = currentList.filter { it.isBookmarked }

            editor.putBoolean(newsItem.title, newsItem.isBookmarked)
            editor.apply()
        }
    }

    fun setNewsList(news: List<NewsItem>) {
        _newsList.value = news
        loadBookmarkedItems()
    }

    fun loadSavedStates(newsItems: List<NewsItem>): List<NewsItem> {
        val updatedList = newsItems.map { item ->
            val isBookmarked = sharedPreferences.getBoolean(item.title, false)
            item.copy(isBookmarked = isBookmarked)
        }
        return updatedList
    }
}