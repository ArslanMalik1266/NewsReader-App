package com.example.newsreaderpractice.ui

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.newsreaderpractice.R
import com.example.newsreaderpractice.adaptor.NewsItem

class newsDetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail_screen)
        val inflater = layoutInflater
        val otherLayout = inflater.inflate(R.layout.recycler_item_news, null)

        val imageView = otherLayout.findViewById<ImageView>(R.id.ivThumbnail)
        val title = otherLayout.findViewById<TextView>(R.id.tvTitle)
        val newsTitle = findViewById<TextView>(R.id.newsTitle)
        val newsImage = findViewById<ImageView>(R.id.newsImage)
        val newsDate = findViewById<TextView>(R.id.newsDate)
        val newsSource = findViewById<TextView>(R.id.newsSource)
        val newsDescription = findViewById<TextView>(R.id.newsDescription)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val newsDetail = intent.getSerializableExtra("newsItem") as? NewsItem
        newsDetail?.let {
            Glide.with(this)
                .load(it.imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(newsImage)
            newsTitle.text = it.title ?: "Title not available"
            newsSource.text = it.source ?: "Source not available"
            newsDate.text = it.date ?: "Date not available"
            newsDescription.text = it.description ?: "Description not available"
        }

    }
}