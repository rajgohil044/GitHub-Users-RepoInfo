package com.test.meeshotest

import com.test.meeshotest.base.BasePresenter
import com.test.meeshotest.models.PullRequest
import com.test.meeshotest.network.ApiClient
import com.test.meeshotest.utils.LogUtils
import com.test.meeshotest.utils.RxUtils

/**
 * Created by Rajender Gohil on 05/05/19.
 */
class SearchPresenter(private val searchView: SearchView) : BasePresenter() {

    companion object {
        private val TAG = SearchPresenter::class.java.simpleName
        private const val STATE = "open"
    }

    override fun loadData() {}

    internal fun refresh(user: String, repo: String) {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }

        searchView.showLoadingView()

        val apiInterface = ApiClient.client.create(ApiInterface::class.java)

        val disposable = apiInterface.getPullRequests(user, repo, STATE)
            .doOnTerminate { searchView.dismissLoadingView() }
            .compose(RxUtils.applyIoMainSchedulers())
            .subscribe({ pullRequests ->
                handleResults(pullRequests)
            }, { throwable ->
                searchView.showToast(searchView.getString(R.string.something_went_worng))
                LogUtils.e(TAG, throwable)
            })
        addSubscription(disposable)
    }

    private fun handleResults(pullRequests: List<PullRequest>?) {
        searchView.onPullRequestsResponse(pullRequests)
    }

}