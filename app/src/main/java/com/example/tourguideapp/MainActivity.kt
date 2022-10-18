package com.example.tourguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tourguideapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        attachTabLayout(binding.tabLayout, binding.viewPager)
    }

    private fun attachTabLayout(tabLayout: TabLayout, viewPager: ViewPager2) {
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = TabType.NATURE.toString()
                }
                1 -> {
                    tab.text = TabType.RELIGION.toString()
                }
                2 -> {
                    tab.text = TabType.MONUMENTS.toString()
                }
            }
        }.attach()
    }
}