package com.test.meeshotest.base

import android.support.v7.widget.RecyclerView

/**
 * Created by Rajender Gohil on 05/05/19.
 */
abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<BaseRecyclerViewHolder<*>>() {

    private val itemsLock = Any()
    private val items = arrayListOf<T>()
    private var onClickListener: OnClickListener? = null
    private var onLongClickListener: OnLongClickListener? = null

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<*>, position: Int) {
        onBind(holder, position)
        holder.setOnClickListener(onClickListener)
        holder.setOnLongClickListener(onLongClickListener)
    }

    abstract fun onBind(holder: BaseRecyclerViewHolder<*>?, position: Int)

    interface OnClickListener {
        fun onClick(position: Int)
    }

    interface OnLongClickListener {
        fun onLongClick(position: Int) : Boolean
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    fun setOnLongClickListener(onLongClickListener: OnLongClickListener) {
        this.onLongClickListener = onLongClickListener
    }

    fun getItems(): List<T> {
        return items
    }

    override fun getItemCount(): Int {
        synchronized(itemsLock) {
            return items.size
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseRecyclerViewHolder<*>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    fun getItem(position: Int): T? {
        synchronized(itemsLock) {
            if (position in 0 until itemCount) {
                return items[position]
            }
            return null
        }
    }

    fun setItem(index: Int, item: T) {
        synchronized(itemsLock) {
            if (index < items.size) {
                items.add(index, item)
            }
        }
    }

    fun setItems(items: List<T>?) {
        synchronized(itemsLock) {
            this.items.clear()
            if (!items.isNullOrEmpty()) {
                this.items.addAll(items)
            }
        }
    }

    fun addItem(item: T) {
        synchronized(itemsLock) {
            items.add(item)
        }
    }

    fun addItems(items: List<T>) {
        synchronized(itemsLock) {
            this.items.addAll(items)
        }
    }

    fun removeItem(item: T) {
        synchronized(itemsLock) {
            items.remove(item)
        }
    }

    fun removeItem(position: Int) {
        synchronized(itemsLock) {
            items.removeAt(position)
        }
    }

    fun clearItems() {
        synchronized(itemsLock) {
            items.clear()
        }
    }

    fun getPosition(type: Int): Int {
        for (pos in 0 until itemCount) {
            if (getItemViewType(pos) == type) {
                return pos
            }
        }
        return RecyclerView.NO_POSITION
    }
}