package com.example.mincongsituitunes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.example.mincongsituitunes.R
import com.example.mincongsituitunes.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    val array = arrayOf(
        "Pop",
        "Classic",
        "Rock"
    )

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position -> tab.text = array[position]
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.pop_icon)
                }
                1 -> {
                    tab.setIcon(R.drawable.classic_icon)
                }
                else -> {
                    tab.setIcon(R.drawable.rock_icon)
                }
            }
        }.attach()
    }
}