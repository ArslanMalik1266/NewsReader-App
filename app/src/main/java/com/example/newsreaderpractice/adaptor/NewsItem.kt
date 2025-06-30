package com.example.newsreaderpractice.adaptor

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class NewsItem(
    @SerializedName("urlToImage")
    val imageUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("author")
    val source: String?,
    val description : String?,
    @SerializedName("publishedAt")
    val date: String?,
    var isBookmarked: Boolean
) : Serializable
