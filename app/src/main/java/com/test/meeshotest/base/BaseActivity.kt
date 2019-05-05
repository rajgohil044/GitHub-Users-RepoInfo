package com.test.meeshotest.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.meeshotest.utils.LogUtils

/**
 * Created by Rajender Gohil on 05/05/19.
 */
abstract class BaseActivity : AppCompatActivity() {

    private val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.d(TAG, "onCreate")
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

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.d(TAG, "onDestroy")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        LogUtils.d(TAG, "onBackPressed")
    }
}