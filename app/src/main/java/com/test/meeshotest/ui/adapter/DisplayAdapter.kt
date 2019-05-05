package com.test.meeshotest.ui.adapter

import android.view.ViewGroup
import com.test.meeshotest.base.BaseRecyclerViewAdapter
import com.test.meeshotest.base.BaseRecyclerViewHolder
import com.test.meeshotest.models.PullRequest
import com.test.meeshotest.ui.adapter.DisplayAdapter.Item
import com.test.meeshotest.ui.viewholder.PullRequestViewHolder

/**
 * Created by Rajender Gohil on 05/05/19.
 */
class DisplayAdapter : BaseRecyclerViewAdapter<Item>() {

    override fun onBind(holder: BaseRecyclerViewHolder<*>?, position: Int) {
        val viewHolder = holder as PullRequestViewHolder
        val pullRequestItem = getItem(position) as PullRequestItem
        viewHolder.bind(pullRequestItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BaseRecyclerViewHolder<*> {
        return PullRequestViewHolder(parent)
    }

    interface Item {
        companion object {
            const val TYPE_PULL_REQUEST = 1
        }

        fun getType() : Int
    }

    class PullRequestItem(val pullRequest: PullRequest) : Item {
        override fun getType(): Int {
            return Item.TYPE_PULL_REQUEST
        }
    }
}