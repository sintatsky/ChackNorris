package com.sintatsky.chacknorris.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sintatsky.chacknorris.R
import com.sintatsky.chacknorris.databinding.ActivityMainBinding
import com.sintatsky.chacknorris.presentation.fragments.JokesFragment
import com.sintatsky.chacknorris.presentation.fragments.WebViewFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_menu_jokes -> {
                    if (supportFragmentManager.findFragmentByTag(JokesFragment.JOKES_FRAGMENT_TAG) == null) {
                        setupCurrentFragment(
                            JokesFragment.newInstance(),
                            JokesFragment.JOKES_FRAGMENT_TAG
                        )
                    }
                    true
                }
                R.id.bottom_nav_menu_web_view -> {
                    if (supportFragmentManager.findFragmentByTag(WebViewFragment.WEB_VIEW_FRAGMENT_TAG) == null) {
                        setupCurrentFragment(
                            WebViewFragment(),
                            WebViewFragment.WEB_VIEW_FRAGMENT_TAG
                        )
                    }
                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null){
            binding.bottomNavigationView.selectedItemId = R.id.bottom_nav_menu_jokes
        }

    }

    private fun setupCurrentFragment(fragment: Fragment, fragmentTag: String = "") {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment, fragmentTag)
            .commit()
    }
}