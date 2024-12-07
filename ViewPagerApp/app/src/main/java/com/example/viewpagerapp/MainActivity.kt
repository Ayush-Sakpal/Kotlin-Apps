package com.example.viewpagerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2
    lateinit var myPagerAdapter: MyPagerAdapter
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Step-1: Initialize  the pageViewer
        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Step-2: Add fragments to list in the adapter class
        myPagerAdapter = MyPagerAdapter(supportFragmentManager, lifecycle)
        myPagerAdapter.addFragmentsToList(FragmentOne())
        myPagerAdapter.addFragmentsToList(FragmentTwo())
        myPagerAdapter.addFragmentsToList(FragmentThree())

        // Step-3: Connecting the  adapter with viewPager
        viewPager2.adapter = myPagerAdapter

        // Step-4: Connecting tabLayout with viewPager2
        tabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(
            tabLayout,
            viewPager2
        ){
            tab, position -> tab.text = "Tab ${position+1}"
        }.attach()
    }
}