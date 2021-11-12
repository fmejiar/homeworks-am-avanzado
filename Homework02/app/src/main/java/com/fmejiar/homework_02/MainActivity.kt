package com.fmejiar.homework_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fmejiar.homework_02.databinding.ActivityMainBinding
import com.fmejiar.homework_02.fragments.ShoppingFragment
import com.fmejiar.homework_02.fragments.VideosFragment
import com.fmejiar.homework_02.fragments.WebFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()

    }

    private fun setUpUI() {
        // binding.viewPager.adapter = TabsAdapter(supportFragmentManager)
        // binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.adapter = TabsAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

            when (position) {
                0 -> tab.text = "WEB"
                1 -> tab.text = "SHOPPING"
                2 -> tab.text = "VIDEOS"
            }

            // tab.text = "${(position + 1)}"
        }.attach()
    }

    /*ViewPager 1*/

    /*inner class TabsAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int = 3

        override fun getPageTitle(position: Int): CharSequence? {
            return "Tab ${position + 1}"
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                1 -> WebFragment()
                2 -> ShoppingFragment()
                else -> VideosFragment()
            }
        }

    }*/

    inner class TabsAdapter(fa: FragmentActivity) :
        FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> WebFragment()
                1 -> ShoppingFragment()
                else -> VideosFragment()
            }
        }

    }

}