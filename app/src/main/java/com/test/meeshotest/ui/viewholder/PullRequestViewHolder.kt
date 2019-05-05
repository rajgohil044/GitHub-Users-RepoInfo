package com.test.meeshotest.ui.viewholder

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.test.meeshotest.utils.ImageHandler
import com.test.meeshotest.R
import com.test.meeshotest.base.BaseRecyclerViewHolder
import com.test.meeshotest.ui.adapter.DisplayAdapter.PullRequestItem
import com.test.meeshotest.utils.bindDimension
import com.test.meeshotest.utils.bindView

/**
 * Created by Rajender Gohil on 05/05/19.
 */
class PullRequestViewHolder(parent: ViewGroup) :
    BaseRecyclerViewHolder<PullRequestItem>(R.layout.item_pull_request, parent) {

    private val pullRequestTitle: TextView by bindView(R.id.title)
    private val pullRequestAuthor: TextView by bindView(R.id.author_name)
    private val authorAvatar: ImageView by bindView(R.id.author_image)
    private val mediumRadius: Int by bindDimension(R.dimen.medium_radius)

    override fun bind(data: PullRequestItem?) {
        data?.apply {
            pullRequest.apply {
                pullRequestTitle.text = title
                user.apply {
                    pullRequestAuthor.text = login
                    Glide.with(getContext()!!)
                        .setDefaultRequestOptions(ImageHandler.getDefaultRequestOptions(mediumRadius))
                        .load(avatarUrl)
                        .into(authorAvatar)
                }
            }
        }
    }
}