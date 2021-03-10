package com.zet.superchat.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.zet.superchat.databinding.ActivityMainBinding
import com.zet.superchat.ui.fragments.chatsList.ChatListFragment
import com.zet.superchat.ui.fragments.SectionsPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            val sectionsPagerAdapter =
                SectionsPagerAdapter(listOf(ChatListFragment(), ChatListFragment()), this@MainActivity)
            pager.adapter = sectionsPagerAdapter
            TabLayoutMediator(tabs, pager) { tab, position ->
                tab.text = "OBJECT ${(position + 1)}"
            }.attach()
            btnNewChat.setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }

    }

}
