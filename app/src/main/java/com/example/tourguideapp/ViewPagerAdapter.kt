package com.example.tourguideapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_OF_FRAGMENTS = 3

class ViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragment, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_OF_FRAGMENTS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NatureFragment()
            1 -> ReligionFragment()
            2 -> MonumentFragment()
            else -> {
                Fragment()
            }
        }
    }
}