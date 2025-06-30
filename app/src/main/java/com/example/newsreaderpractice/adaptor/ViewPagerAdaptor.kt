package com.example.newsreaderpractice.adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsreaderpractice.ui.BookmarkFragment
import com.example.newsreaderpractice.ui.HomeFragment

class ViewPagerAdaptor(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> BookmarkFragment()
            else -> throw IllegalStateException("Invalid position")
        }

    }
}
