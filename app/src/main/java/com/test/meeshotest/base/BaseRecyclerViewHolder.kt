package com.test.meeshotest.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.test.meeshotest.base.BaseRecyclerViewAdapter.OnClickListener
import com.test.meeshotest.base.BaseRecyclerViewAdapter.OnLongClickListener

/**
 * Created by Rajender Gohil on 05/05/19.
 */
abstract class BaseRecyclerViewHolder<T>(layoutResId: Int, parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)),
    View.OnClickListener, View.OnLongClickListener {

    private var onClickListener: OnClickListener? = null
    private var onLongClickListener: OnLongClickListener? = null

    init {
        ButterKnife.bind(this, itemView)
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    abstract fun bind(data: T?)

    fun getContext(): Context? {
        return itemView.context
    }

    override fun onClick(view: View?) {
        onClickListener?.apply {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onClick(position)
            }
        }
    }

    override fun onLongClick(view: View?): Boolean {
        val isOnLongClicked = onLongClickListener?.let {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                it.onLongClick(position)
            } else {
                false
            }
        }
        return isOnLongClicked ?: false
    }

    fun setOnClickListener(onClickListener: OnClickListener?) {
        this.onClickListener = onClickListener
    }

    fun setOnLongClickListener(onLongClickListener: OnLongClickListener?) {
        this.onLongClickListener = onLongClickListener
    }
}