package com.example.mincongsituitunes.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


private const val TABS = 3

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle)
    :FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
        return TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return ItunesListFragment("pop")
            1 -> return ItunesListFragment("classic")
        }
        return ItunesListFragment("rock")
    }


}