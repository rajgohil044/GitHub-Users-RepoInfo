package com.test.meeshotest.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.test.meeshotest.ClickListener
import com.test.meeshotest.R
import com.test.meeshotest.SearchPresenter
import com.test.meeshotest.SearchView
import com.test.meeshotest.base.BaseFragment
import com.test.meeshotest.models.PullRequest
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * Created by Rajender Gohil on 05/05/19.
 */
class SearchFragment : BaseFragment(), SearchView {

    private lateinit var searchPresenter: SearchPresenter
    private lateinit var listener: ClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initListeners()
    }

    private fun initPresenter() {
        searchPresenter = SearchPresenter(this)
    }

    private fun initListeners() {
        search.setOnClickListener {
            search()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement " + ClickListener::class.java.simpleName)
        }
    }

    override fun onResume() {
        super.onResume()
        searchPresenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        searchPresenter.unSubscribe()
    }

    override fun showLoadingView() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun dismissLoadingView() {
        swipeRefreshLayout.isRefreshing = false
    }

    private fun search() {
        val userName = username.text.toString()
        val repoName = reponame.text.toString()

        if (userName.isNotBlank() && repoName.isNotBlank()) {
            searchPresenter.refresh(userName, repoName)
        } else {
            showToast(getString(R.string.alert))
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onPullRequestsResponse(pullResuests: List<PullRequest>?) {
        pullResuests?.apply {
            if (this.isNotEmpty()) {
                listener.onResponse(this)
            } else {
                showToast(getString(R.string.something_went_worng))
            }
        }
    }
}