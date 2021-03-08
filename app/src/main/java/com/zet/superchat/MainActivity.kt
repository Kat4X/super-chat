package com.zet.superchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.zet.superchat.databinding.ActivityMainBinding
import com.zet.superchat.ui.main.MainPlaceholderFragment
import com.zet.superchat.ui.main.SectionsPagerAdapter
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
                SectionsPagerAdapter(listOf(MainPlaceholderFragment(), MainPlaceholderFragment()), this@MainActivity)
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