package com.github.user.network.request

import com.github.user.database.Repo
import com.github.user.network.NetworkModule
import com.github.user.network.client.RepoApi
import com.github.user.network.errorhandler.ApiErrorHandler
import com.github.user.network.errorhandler.RepoErrorHandler
import com.github.user.network.requesthandler.GenericRequestHandler
import retrofit2.Call

class RepoRequest : GenericRequestHandler<List<Repo>>() {
    private val repoApi: RepoApi by lazy {
        NetworkModule.createRetrofit().create(RepoApi::class.java)
    }

    override val errorHandler: ApiErrorHandler = RepoErrorHandler()

    override fun makeRequest(): Call<List<Repo>> {
        return repoApi.users()
    }
}