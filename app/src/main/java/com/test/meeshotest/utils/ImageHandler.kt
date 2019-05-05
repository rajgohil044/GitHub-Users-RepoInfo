package com.test.meeshotest.utils

import android.support.annotation.IdRes
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.test.meeshotest.R

/**
 * Created by Rajender Gohil on 05/05/19.
 */
object ImageHandler  {

    fun getDefaultRequestOptions(@IdRes resId: Int) : RequestOptions {
        return RequestOptions().apply {
            centerCrop().transform(RoundedCorners(resId))
            placeholder(R.drawable.image_placeholder)
            error(R.drawable.image_placeholder)
        }
    }
}