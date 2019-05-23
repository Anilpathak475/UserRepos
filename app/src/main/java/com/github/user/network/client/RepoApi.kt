package com.github.user.network.client

import com.github.user.database.Repo
import retrofit2.Call
import retrofit2.http.GET

interface RepoApi {
    @GET("/users/anilpathak475/repos")
    fun users(
    ): Call<List<Repo>>
}