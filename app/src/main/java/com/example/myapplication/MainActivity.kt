package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.databinding.ActvityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private val binding: ActvityMainBinding by lazy { ActvityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true) // with onOptionsItemSelected
        /*        binding.toolbar.setNavigationOnClickListener {
                    finish()
                }*/

        val adapter = SimpleFragmentPagerAdapter(supportFragmentManager, lifecycle = lifecycle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = adapter.tabTitles[position]
            }).attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    inner class SimpleFragmentPagerAdapter constructor(fm: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm, lifecycle) {

        val tabTitles = arrayOf("菜单一", "菜单二")
        private val mFragment = arrayOf(Fragment4(), Fragment4())

        override fun getItemCount(): Int {
            return mFragment.size
        }

        override fun createFragment(position: Int): Fragment {
            return mFragment[position]
        }
    }
}