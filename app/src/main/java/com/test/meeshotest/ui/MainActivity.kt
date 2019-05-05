package com.test.meeshotest.ui

import android.os.Bundle
import com.test.meeshotest.ClickListener
import com.test.meeshotest.R
import com.test.meeshotest.base.BaseActivity
import com.test.meeshotest.models.PullRequest

class MainActivity : BaseActivity(), ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchToSearchFragment()
    }

    private fun switchToSearchFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, SearchFragment())
            commitAllowingStateLoss()
        }
    }

    private fun switchToDisplayFragment(pullRequests: List<PullRequest>) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, DisplayFragment.newInstance(pullRequests))
            addToBackStack("DisplayFragment")
            commitAllowingStateLoss()
        }
    }

    override fun onResponse(pullRequests: List<PullRequest>) {
        switchToDisplayFragment(pullRequests)
    }
}
