package com.test.meeshotest.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.meeshotest.utils.LogUtils

/**
 * Created by Rajender Gohil on 05/05/19.
 */
abstract class BaseFragment : Fragment() {

    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.d(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtils.d(TAG, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.d(TAG, "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogUtils.d(TAG, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.d(TAG, "onDestroy")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        LogUtils.d(TAG, "onViewStateRestored")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtils.d(TAG, "onSaveInstanceState")
    }
}