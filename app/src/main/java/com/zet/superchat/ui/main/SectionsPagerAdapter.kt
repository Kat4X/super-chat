package com.zet.superchat.ui.main

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(
    private val data: List<Fragment>,
    fm: FragmentActivity
) : FragmentStateAdapter(fm) {

    override fun getItemCount() = data.size

    override fun createFragment(position: Int): Fragment {
        return data[position]
    }
}