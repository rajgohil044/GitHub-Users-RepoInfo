package com.test.meeshotest

import android.support.annotation.StringRes
import com.test.meeshotest.models.PullRequest

/**
 * Created by Rajender Gohil on 05/05/19.
 */
interface SearchView {

    fun showLoadingView()

    fun dismissLoadingView()

    fun showToast(msg: String)

    fun getString(@StringRes resId: Int) : String

    fun onPullRequestsResponse(pullResuests: List<PullRequest>?)
}