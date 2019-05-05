package com.test.meeshotest.utils

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Rajender Gohil on 05/05/19.
 */
fun <T : View> RecyclerView.ViewHolder.bindView(@IdRes resId: Int): Lazy<T> {
    return lazy {
        itemView.findViewById<T>(resId)
    }
}

fun RecyclerView.ViewHolder.bindDimension(@IdRes resId: Int): Lazy<Int> {
    return lazy {
        itemView.context.resources.getDimensionPixelOffset(resId)
    }
}