package com.test.meeshotest

import com.test.meeshotest.models.PullRequest

/**
 * Created by Rajender Gohil on 05/05/19.
 */
interface ClickListener {
    fun onResponse(pullRequests: List<PullRequest>)
}