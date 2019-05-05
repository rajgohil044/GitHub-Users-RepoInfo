package com.test.meeshotest.base

import com.test.meeshotest.utils.LogUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Rajender Gohil on 05/05/19.
 */
abstract class BasePresenter {

    private val TAG = javaClass.simpleName

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    abstract fun loadData()

    fun subscribe() {
        LogUtils.d(TAG, "subscribe")
        loadData()
    }

    fun unSubscribe() {
        LogUtils.d(TAG, "unSubscribe")
        compositeDisposable.dispose()
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}