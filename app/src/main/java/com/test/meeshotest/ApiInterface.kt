package com.test.meeshotest

import com.test.meeshotest.models.PullRequest
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Rajender Gohil on 05/05/19.
 */
interface ApiInterface {

    @GET("/repos/{user}/{repo}/pulls")
    fun getPullRequests(
        @Path("user") user: String,
        @Path("repo") repo: String,
        @Query("state") state: String
    ): Observable<List<PullRequest>>
}