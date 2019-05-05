package com.test.meeshotest.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.meeshotest.R
import com.test.meeshotest.base.BaseFragment
import com.test.meeshotest.models.PullRequest
import com.test.meeshotest.ui.adapter.DisplayAdapter
import com.test.meeshotest.ui.adapter.DisplayAdapter.Item
import com.test.meeshotest.ui.adapter.DisplayAdapter.PullRequestItem
import java.util.*
import kotlinx.android.synthetic.main.fragment_display.*

/**
 * Created by Rajender Gohil on 05/05/19.
 */
class DisplayFragment : BaseFragment() {

    companion object {
        private const val ARG_PULL_REQUESTS = "ARG_PULL_REQUESTS"

        fun newInstance(pullRequests: List<PullRequest>) = DisplayFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_PULL_REQUESTS, pullRequests as ArrayList<out PullRequest>)
            }
        }
    }

    private val displayAdapter = DisplayAdapter()
    private var pullRequests: List<PullRequest>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArguments()
        initRecyclerView()
        setItems()
    }

    private fun initArguments() {
        arguments?.apply {
            pullRequests = getParcelableArrayList(ARG_PULL_REQUESTS)
        }
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = displayAdapter
        }
    }

    private fun setItems() {
        pullRequests?.apply {
            val pullRequestItems = getPullRequestItems(this)
            if(pullRequestItems.isNotEmpty()) {
                displayAdapter.apply {
                    setItems(pullRequestItems)
                    notifyDataSetChanged()
                }
            }
        }
    }

    private fun getPullRequestItems(pullRequests: List<PullRequest>) : List<Item> {
        return arrayListOf<Item>().apply {
            for(pullRequest in pullRequests) {
                add(PullRequestItem(pullRequest))
            }
        }
    }
}